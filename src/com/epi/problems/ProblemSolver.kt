package com.epi.problems

/**
 * A utility class for the solutions of problems
 * which doesn't warrant an individual class
 */
class ProblemSolver{
companion object {

    /**
     * Solves the maximum profit calculation problem,
     * given in the introduction part of EPI
     *
     * @param prices array of share prices
     */
    fun calculateMaxProfit(prices: Array<Double>): Double{
        var maxProfit = 0.0
        var minimum = Double.MAX_VALUE
        for(price in prices){
           maxProfit = Math.max(maxProfit, price - minimum)
           minimum = Math.min(minimum, price)
        }
        return maxProfit
    }
}
}