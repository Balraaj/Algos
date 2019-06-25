package com.example.practice.problems;

import com.example.util.Util;

public class MatrixNullify {



    public static void nullify(int[][] arr){
        boolean firstRowNullable, firstColNullable;
        firstColNullable = (arr[0][0] ==0)?true:isFirstColNullable(arr);
        firstRowNullable = (arr[0][0] ==0)?true:isFirstRowNullable(arr);

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(arr[i][j]==0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for(int i=1;i<arr[0].length;i++) {
            if(arr[0][i]==0) nullifyColumn(arr,arr.length,i);
        }

        for(int i=1;i<arr[0].length;i++) {
            if(arr[i][0]==0) nullifyRow(arr,arr[0].length,i);
        }

        if(firstColNullable) nullifyColumn(arr,arr.length,0);
        if(firstRowNullable) nullifyRow(arr,arr[0].length,0);
    }

    private static boolean isFirstRowNullable(int[][] array){
        for(int i=0;i<array[0].length;i++){
            if(array[0][i]==0) return true;
        }
        return false;
    }

    private static boolean isFirstColNullable(int[][] array){
        for(int i=0;i<array.length;i++){
            if(array[i][0]==0) return true;
        }
        return false;
    }

    private static void nullifyColumn(int[][] array, int maxRow, int column){
        for(int i=0;i<maxRow;i++){
            array[i][column] = 0;
        }
    }

    private static void nullifyRow(int[][] array, int maxColumn, int row){
        for(int i=0;i<maxColumn;i++){
            array[row][i] = 0;
        }
    }

    public static void main(String[] args){
        int[][] array = {
                {0,11,12,13},
                {14,15,16,17},
                {18,19,0,0},
                {0,23,24,25}};
        System.out.println("Array before nullify : ");
        Util.print2dArray(array);
        nullify(array);
        System.out.println("Array after nullify : ");
        Util.print2dArray(array);
    }
}
