package com.ben.montecarlo;

/*
 * This class represents a single trade.
 *  Hundreds to thousands of Trade objects make up one Simulation object,
 *  and hundreds to thousands of Simulation objects make up one Monte Carlo object.
 */
public class Trade
{
    // Each trade has a unique ID from 1 to infinity
    int     tradeID;
    double  netR;

    // Calculated Field: True if the netR is greater than zero, false otherwise
    boolean isWin;


    public Trade(int tradeID, double netR)
    {
        this.tradeID = tradeID;
        this.netR    = netR;
        this.isWin   = netR > 0;
    }
}