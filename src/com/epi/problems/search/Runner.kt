package com.epi.problems.search

fun main(){

    print(ProblemSolver.findRotationPoint(arrayOf(1,2,3,4,5,6)))
    print(ProblemSolver.findRotationPoint(arrayOf(6,1,2,3,4,5)))
    print(ProblemSolver.findRotationPoint(arrayOf(5,6,1,2,3,4)))
    print(ProblemSolver.findRotationPoint(arrayOf(4,5,6,1,2,3)))
    print(ProblemSolver.findRotationPoint(arrayOf(3,4,5,6,1,2)))
    print(ProblemSolver.findRotationPoint(arrayOf(2,3,4,5,6,1)))
}