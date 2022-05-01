package com.ben.montecarlo;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //=============================================================
        // Get user input
        //=============================================================
        // Initalize the scanner object as 'sc', which will be used to listen to user input line by line.
        Scanner sc = new Scanner(System.in);

        // Ask user to input winrate
        System.out.println("Please input your win probability as a decimal (0.0 - 1.0)");
        System.out.print(" > ");
        double winRate = sc.nextDouble();
        //=============================================================
    }
}