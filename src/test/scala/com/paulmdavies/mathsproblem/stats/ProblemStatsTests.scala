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
    
    it should "know the percentage of problems answered correctly" in
    {
        forAll{ ( left : Int, right : Int ) => {
            val ps = ProblemStats()
            ps.correctPercentage should equal ( 0 )
            ps.add( AdditionProblem( left, right ), left + right )
            ps.correctPercentage should equal ( 100 )
            ps.add( AdditionProblem( left, right ), left + right + 1 )
            ps.correctPercentage should equal ( 50 )
        } }
    }
    
    it should "know the percentage of problems answered incorrectly" in
    {
        forAll{ ( left : Int, right : Int ) => {
        	val ps = ProblemStats()
            ps.incorrectPercentage should equal ( 0 )
            ps.add( AdditionProblem( left, right ), left + right )
            ps.incorrectPercentage should equal ( 0 )
            ps.add( AdditionProblem( left, right ), left + right + 1 )
            ps.incorrectPercentage should equal ( 50 )
        } }
    }
    
    it should "report correctly" in
    {
        val ps = ProblemStats()
        ps.report should equal ( "=== Report ===\n\nNo problems attempted" )
        ps.add( AdditionProblem( 1, 1 ), 2 )
        ps.add( AdditionProblem( 1, 1 ), 3 )
        ps.report should equal ( "=== Report ===\n\nProblems attempted: 2\nCorrect: 1 (50.0%)\nIncorrect: 1 (50.0%)" )
    }
}