package com.paulmdavies.mathsproblem.stats

import org.scalatest._
import Matchers._
import org.scalatest.prop._
import com.paulmdavies.mathsproblem._

class ProblemStatsTests extends FlatSpec with Matchers with PropertyChecks 
{
    it should "increment the count whenever problems are added" in
    {
        val ps = ProblemStats()
        forAll{ ( left : Int, right : Int ) => {
            val count = ps.count
            ps.add( AdditionProblem( left, right ), left + right )
            ps.count should equal { count + 1 }
            ps.add( AdditionProblem( left, right ), left + right + 1 )
            ps.count should equal { count + 2 }
        } }
    }
    
    it should "increment the correct count only when correctly-answered problems are added" in
    {
        val ps = ProblemStats()
        forAll{ ( left : Int, right : Int ) => {
            val correctCount = ps.correctCount
            ps.add( AdditionProblem( left, right ), left + right )
            ps.correctCount should equal { correctCount + 1 }
            ps.add( AdditionProblem( left, right ), left + right + 1 )
            ps.correctCount should equal { correctCount + 1 }
        } }
    }
    
    it should "have incorrect count equal to total count minus correct count" in
    {
        val ps = ProblemStats()
        forAll{ ( left : Int, right : Int ) => {
            val incorrectCount = ps.incorrectCount
            ps.add( AdditionProblem( left, right ), left + right )
            ps.incorrectCount should equal { incorrectCount }
            ps.add( AdditionProblem( left, right ), left + right + 1 )
            ps.incorrectCount should equal { incorrectCount + 1 }
        } }
    }
}