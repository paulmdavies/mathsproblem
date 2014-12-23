package com.paulmdavies.mathsproblem

import org.scalatest._
import Matchers._

class ProblemGeneratorTests extends FlatSpec with Matchers
{
    it should "generate a random problem within the given bounds" in
    {
        val generator = ProblemGenerator( 0, 10 )
        val problem = generator.apply()
        ( 0 until 10 ) should contain ( problem.left )
        ( 0 until 10 ) should contain ( problem.right )
    }
    
    it should "fail if lower limit is less than upper limit" in
    {
        an [IllegalArgumentException] should be thrownBy ProblemGenerator( 1, 0 )
    }
}