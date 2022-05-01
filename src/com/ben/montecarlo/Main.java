package com.ben.montecarlo;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //================================================================
        // Get user input
        //================================================================
        // Initalize the scanner object as 'sc', which will be used to listen to user input line by line.
        Scanner sc = new Scanner(System.in);

        // Ask user to input winrate
        inputPrompt("Please input your win probability as a decimal (eg 0.385)");
        double winRate = sc.nextDouble();
        if (winRate < 0.0 || winRate > 1.0)
        {
            System.out.println("ERROR: Win probability must be a decimal between 0.0 and 1.0");
            System.exit(1);
        }

        // Ask the user to input their average winning trade (expressed as an R multiple)
        inputPrompt("Please input your average win expressed as an R multiple (eg 2.37)");
        double avgWin = sc.nextDouble();
        if (avgWin < 0.0)
        {
            System.out.println("ERROR: Average winning trade must be greater than 0!");
            System.exit(1);
        }

        // Ask the user to input their average losing trade (expressed as an R multiple)
        inputPrompt("Please input your average loss expressed as an R multiple (eg -0.67)");
        double avgLoss = sc.nextDouble();
        if (avgLoss > 0.0)
        {
            System.out.println("ERROR: Average losing trade must be less than 0!");
        }

        // Ask the user to input average costs per trade (expressed as R multiple)
        inputPrompt("Please input your average cost per trade expressed as an R multiple (eg -0.13)");
        double costPerTrade = sc.nextDouble();
        if (costPerTrade > 0.0)
        {
            System.out.println("ERROR: Cost per trade must be less than 0!");
            System.exit(1);
        }

        // Ask the user how many simulations they would like to run in the monte carlo iteration
        inputPrompt("How many simulations would you like to run in each monte carlo iteration?");
        int numOfSims = sc.nextInt();
        if (numOfSims < 0)
        {
            System.out.println("ERROR: Number of simulations must be greater than 0!");
            System.exit(1);
        }

        // Ask the user how many trades each simulation should generate
        inputPrompt("How many trades should each simulation generate?");
        int numOfTrades = sc.nextInt();
        if (numOfTrades < 0)
        {
            System.out.println("ERROR: Number of trades must be greater than 0!");
            System.exit(1);
        }
        //================================================================
    }

    //================================================================
    // Helper function to print input prompts to the console
    //================================================================
    public static void inputPrompt(String inputPrompt)
    {
        System.out.println(inputPrompt);
        System.out.print(" > ");
    }
    //================================================================
}