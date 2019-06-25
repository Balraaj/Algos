package com.example.practice.problems;

import com.example.util.Util;

/*
    Given a N X N matrix rotate it by 90 degrees.
 */
public class MatrixRotate {

    public static void rotateSquareMatrix(int[][] array, int startRow, int startCol, int endRow, int endCol){

        if((startRow>=endRow) || (startCol>=endCol)) return;
        for(int i=0;i<(endRow-startRow);i++){
            int temp = array[startRow][startCol+i];
            array[startRow][startCol+i] = array[startRow+i][endCol];
            array[startRow+i][endCol] = array[endRow][endCol-i];
            array[endRow][endCol-i] = array[endRow-i][startCol];
            array[endRow-i][startCol] = temp;
        }

        rotateSquareMatrix(array, startRow+1,startCol+1,endRow-1,endCol-1);
    }

    public static void main(String[] args){
        int[][] array = {{10,11,12,13},{14,15,16,17},{18,19,20,21},{22,23,24,25}};
        System.out.println("Array before rotation : ");
        Util.print2dArray(array);
        rotateSquareMatrix(array,0,0,3,3);
        System.out.println("Array after rotation : ");
        Util.print2dArray(array);
    }
}
