package com.paulmdavies.mathsproblem

trait Problem
{
    private [mathsproblem] val left : Int
    private [mathsproblem] val right : Int
    private [mathsproblem] val answer : Int
    
    def guess( possibleAnswer : Int ) : Boolean = possibleAnswer == answer
}