package com.ben.montecarlo;

/*
 * This class represents a single Simulation.
 *  Hundreds to thousands of Trade objects make up one Simulation object,
 *  and hundreds to thousands of Simulation objects make up one MonteCarlo object.
 */
public class Simulation
{
    // Number of trades the simulation should simulate
    int numOfTrades;

    // For each randomly generated trade, this is the probability that the trade will be a winner
    double winRate;

    // User-determined average size of each winning and losing trade
    double avgWin, avgLoss;

    // Constructor for a simulation
    public Simulation(int numOfTrades, double winRate, double avgWin, double avgLoss)
    {
        this.numOfTrades = numOfTrades;
        this.winRate     = winRate;
        this.avgWin      = avgWin;
        this.avgLoss     = avgLoss;
    }
}
