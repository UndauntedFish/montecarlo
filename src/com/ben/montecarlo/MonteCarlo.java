package com.ben.montecarlo;

/*
 * This class represents a full Monte Carlo simulation.
 *  Hundreds to thousands of Trade objects make up one Simulation object,
 *  and hundreds to thousands of Simulation objects make up one MonteCarlo object.
 */
public class MonteCarlo
{
    // Number of simulations the Monte Carlo simulation should run
    int numOfSims;

    // Number of trades each simulation should simulate
    int numOfTrades;

    // Store all the trades ran in this simulation in this trades array
    Simulation[] sims;

    // For each randomly generated trade, this is the probability that the trade will be a winner
    double winRate;

    // User-determined average size of each winning and losing trade
    double avgWin, avgLoss;

    public MonteCarlo(int numOfSims, int numOfTrades, double winRate, double avgWin, double avgLoss)
    {
        this.numOfSims   = numOfSims;
        this.numOfTrades = numOfTrades;
        this.winRate     = winRate;
        this.avgWin      = avgWin;
        this.avgLoss     = avgLoss;

        runSimulations();
    }

    // Helper method to run however many simulations the user needs to run
    private void runSimulations()
    {
        // Create an array of Simulations
        sims = new Simulation[numOfSims];

        // Run 'numOfSims' number of simulations, and store their results in the sims array
        for (int i = 0; i < sims.length; i++)
        {
            sims[i] = new Simulation(i + 1, this);
        }
    }

    // Return a nicely formatted String to visualize only the results of each individual simulation in the Monte Carlo simulation.
    public String toStringOnlySims()
    {
        String monteCarloStr = "";

        // Iterate through all simulations
        for (Simulation sim : sims)
        {
            // Print a nicely formatted String to visualize the components of the current simulation
            monteCarloStr += sim.toString() + "\n";
        }

        return monteCarloStr;
    }

    @Override
    public String toString()
    {
        String monteCarloStr = "";

        // Iterate through all simulations
        for (Simulation sim : sims)
        {
            // Print a nicely formatted String to visualize the components of the current simulation
            monteCarloStr += sim.toString() + "\n";

            // Get all the trades in the current simulation
            Trade[] trades = sim.trades;

            // Iterate through all trades in the current simulation
            for (Trade trade : trades)
            {
                // Print a nicely formatted String to visualize the components of the current trade
                monteCarloStr += trade.toString() + "\n";
            }
        }

        return monteCarloStr;
    }
}
