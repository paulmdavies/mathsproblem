package com.paulmdavies.mathsproblem.stats

import com.paulmdavies.mathsproblem._

object ProblemStats
{
    def apply() : ProblemStats = new ProblemStats()
}

class ProblemStats private [stats] ()
{
    private [stats] var count = 0
    private [stats] var correctCount = 0
    
    private [stats] def incorrectCount = count - correctCount
    
    def add( problem : Problem, answer : Int ) : Unit =
    {
        count += 1
        if ( problem.guess( answer ) ) correctCount += 1
    }
}