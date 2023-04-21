# montecarlo

montecarlo is a command-line Java program that performs a Monte-Carlo simulation on trading systems. It does this by drawing a user-specified large number of trades from the trading system's probability distribution for a large number of trials (also user-specified).

Here is an example of using the program to simulate the possible outcomes of 50,000,000 trades with a trading strategy with the following statistics:
 - Win probability: 60%
 - Size of average win: 2.37R (2.37 times the initial risk of each trade, more about the "R" multiple here: https://www.vantharp.com/trading/wp-content/uploads/2018/06/A_Short_Lesson_on_R_and_R-multiple.pdf)
 - Size of average loss: -1R
 - Average cost per trade (commisions, spread, extra fees, etc.): -0.05R
 
 ![image](https://user-images.githubusercontent.com/58181651/233719841-6e4aa196-cc5e-4c49-a82b-b9c2257408b5.png)


The purpose of doing this is to stress test a trading system by seeing how it may play out over the course of millions of different scenarios.
