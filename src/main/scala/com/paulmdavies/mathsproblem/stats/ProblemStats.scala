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
    
    private [stats] def correctPercentage = perc( correctCount, count )
    private [stats] def incorrectPercentage = perc( incorrectCount, count )
    
    private def perc( num : Int, denom : Int ) : Float = denom == 0 match
    {
        case true => 0.0f
        case false => num * 100 / denom.toFloat
    } 
    
    def report() : String = 
    {
        val header = "=== Report ===\n\n"
        val body = count == 0 match
        {
            case true => "No problems attempted"
            case false => "Problems attempted: %d\nCorrect: %d (%.1f%%)\nIncorrect: %d (%.1f%%)"
                .format( count, correctCount, correctPercentage, incorrectCount, incorrectPercentage )
        }
        
        header + body
    }
}