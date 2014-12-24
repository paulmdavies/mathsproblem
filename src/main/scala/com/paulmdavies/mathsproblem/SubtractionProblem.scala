package com.paulmdavies.mathsproblem

object SubtractionProblem
{
    def apply( left : Int, right : Int ) : SubtractionProblem = new SubtractionProblem( left, right )
}

class SubtractionProblem private [mathsproblem]( private [mathsproblem] val left : Int, private [mathsproblem] val right : Int ) extends Problem
{
    val answer = left - right
    
    override def toString() : String = "%d - %d".format( left, right )
}