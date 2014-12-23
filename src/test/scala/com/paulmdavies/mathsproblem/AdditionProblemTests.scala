package com.paulmdavies.mathsproblem

import org.scalatest._
import Matchers._

class AdditionProblemTests extends FlatSpec with Matchers
{
    it should "be constructable from two integers" in
    {
        AdditionProblem( 1, 2 )
    }
    
    it should "know the answer to the problem" in
    {
        AdditionProblem( 1, 2 ).answer should equal ( 3 )
    }
    
    it should "be able to tell if a guess is correct" in
    {
        AdditionProblem( 1, 2 ).guess( 3 ) should equal ( true )
        AdditionProblem( 1, 2 ).guess( 4 ) should equal ( false )
    }
    
    it should "serialise correctly" in
    {
        AdditionProblem( 1, 2 ).toString should equal( "1 + 2" )
    }
}