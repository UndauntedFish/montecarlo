package com.ben.montecarlo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * This class represents a single Simulation.
 *  Hundreds to thousands of Trade objects make up one Simulation object,
 *  and hundreds to thousands of Simulation objects make up one MonteCarlo object.
 */
public class Simulation
{
    // Store the parent MonteCarlo class
    MonteCarlo monteCarlo;

    // Each simulation has a unique ID from 1 to infinity
    int simID;

    // Store all the trades ran in this simulation in this trades array
    Trade[] trades;

    // Constructor for a simulation
    public Simulation(int simID, MonteCarlo monteCarlo)
    {
        this.simID      = simID;
        this.monteCarlo = monteCarlo;
        this.trades     = new Trade[monteCarlo.numOfTrades];

        runSimulation();
    }

    // Helper function: Run one simulation of however many trades specified in monteCarlo
    private void runSimulation()
    {
        for (int i = 0; i < monteCarlo.numOfTrades; i++)
        {
            trades[i] = new Trade(i + 1, this);
        }
    }

    // Returns the winrate observed among the trades in this simulation
    public double getObservedWinRate()
    {
        // Calculate the number of trades won in this simulation
        int tradesWon = 0;

        // Iterate through each trade in this simulation
        for (Trade trade : trades)
        {
            // If the trade is a win, increment tradesWon
            if (trade.isWin)
                tradesWon++;
        }

        // Divide that by the total number of trades in this simulation to get winrate. Round to 4 decimal places.
        return roundDecimalUsingBigDecimal(tradesWon / (double) trades.length, 4);
    }

    // Returns the profit factor observed in this simualtion
    public double getObservedProfitFactor()
    {
        // Calculate the R won and lost in this simualtion
        double rWon = 0.0, rLost = 0.0;

        // Iterate through each trade in this simulation
        for (Trade trade : trades)
        {
            // If the trade is a win, add the R won by the trade to rWon
            // If the trade is a loss, add the R lost by the trade to rLost
            if (trade.isWin)
                rWon += trade.netR;
            else
                rLost += Math.abs(trade.netR);
        }

        // Calculate and return the Profit Factor (net gains / net losses). Round to 2 decimal places.
        return roundDecimalUsingBigDecimal(rWon / rLost, 2);
    }

    // Helper function: rounds a decimal using BigDecimal to preserve precision
    public static double roundDecimalUsingBigDecimal(double value, int decimalPlace)
    {
        return Double.parseDouble(new BigDecimal(Double.toString(value)).setScale(decimalPlace, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
    }

    // Returns a nicely formatted String to visualize the components of this Simulation
    @Override
    public String toString()
    {
        // Calculate how much total R was won from all trades combined.
        double totalAccumulatedR = 0.0;
        for (Trade trade : trades)
        {
            totalAccumulatedR += trade.netR;
        }

        return "Simulation #" + simID +
                ", # of Trades = " + trades.length +
                ", Observed Win Rate = " + getObservedWinRate() * 100 +
                "%, Observed Profit Factor = " + getObservedProfitFactor() +
                ", Accumulated R = " + totalAccumulatedR;
    }
}
