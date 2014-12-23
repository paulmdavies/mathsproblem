package com.paulmdavies.mathsproblem.stats

import org.scalatest._
import Matchers._
import com.paulmdavies.mathsproblem._

class ProblemStatsTests extends FlatSpec with Matchers 
{
    it should "increment the count whenever problems are added" in
    {
        val ps = ProblemStats()
        ps.count should equal( 0 )
        ps.add( AdditionProblem( 1, 2 ), 3 )
        ps.count should equal( 1 )
        ps.add( AdditionProblem( 1, 2 ), 7 )
        ps.count should equal( 2 )
    }
    
    it should "increment the correct count only when correctly-answered problems are added" in
    {
        val ps = ProblemStats()
        ps.correctCount should equal( 0 )
        ps.add( AdditionProblem( 1, 2 ), 3 )
        ps.correctCount should equal( 1 )
        ps.add( AdditionProblem( 1, 2 ), 7 )
        ps.correctCount should equal( 1 )
    }
    
    it should "have incorrect count equal to total count minus correct count" in
    {
        val ps = ProblemStats()
        ps.incorrectCount should equal( 0 )
        ps.add( AdditionProblem( 1, 2 ), 3 )
        ps.incorrectCount should equal( 0 )
        ps.add( AdditionProblem( 1, 2 ), 7 )
        ps.incorrectCount should equal( 1 )
    }
}