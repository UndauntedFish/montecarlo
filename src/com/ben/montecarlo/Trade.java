package com.ben.montecarlo;

/*
 * This class represents a single trade.
 *  Hundreds to thousands of Trade objects make up one Simulation object,
 *  and hundreds to thousands of Simulation objects make up one MonteCarlo object.
 */
public class Trade
{
    // Store the parent MonteCarlo class
    private MonteCarlo monteCarlo;

    // Store the parent Simulation class
    private Simulation sim;

    // Each trade has a unique ID from 1 to infinity
    int tradeID;

    // Each trade can win or lose R. Its R won or lost is expressed here.
    double netR;

    // Calculated Field: True if the netR is greater than zero, false otherwise
    boolean isWin;

    // Constructor for a Trade
    public Trade(int tradeID, Simulation sim)
    {
        this.tradeID    = tradeID;
        this.sim        = sim;
        // Get the MonteCarlo object associated with the input simulation
        this.monteCarlo = sim.monteCarlo;

        // Generate a trade result
        this.isWin      = generateTradeResult();

        // If the generated trade result gives a winning trade, set the net R to a win. Vice versa for a loss.
        this.netR       = isWin ? monteCarlo.avgWin : monteCarlo.avgLoss;
    }

    private boolean generateTradeResult()
    {
        // Math.random() generates a random number between 0.0 and 1.0
        // Returns true if the random number falls within the winrate
        return Math.random() <= monteCarlo.winRate;
    }

    // Returns the simulation ID of the simulation that this trade is a part of
    public String getSimulationID()
    {
        return Integer.toString(sim.simID);
    }

    // Returns a nicely formatted String to visualize the components of this trade
    @Override
    public String toString()
    {
        // Trade #1  |  isWin = T  |  netR = +2.5
        // Trade #2  |  isWin = F  |  netR = -1.0
        String tradeIDStr = Integer.toString(tradeID);

        // Format the isWin part of the output String
        String isWinStr = "";
        if (tradeIDStr.length() >= 4)
            isWinStr = "|  isWin = " + (isWin ? "T" : "F");
        else if (tradeIDStr.length() >= 3)
            isWinStr = "  |  isWin = " + (isWin ? "T" : "F");
        else if (tradeIDStr.length() >= 2)
            isWinStr = "   |  isWin = " + (isWin ? "T" : "F");
        else if (tradeIDStr.length() >= 1)
            isWinStr = "    |  isWin = " + (isWin ? "T" : "F");

        // format the netR part of the output String
        String netRStr = "  |  netR = " + (netR > 0 ? "+" + netR : netR);

        return "   Trade #" + tradeID + isWinStr + netRStr;
    }
}