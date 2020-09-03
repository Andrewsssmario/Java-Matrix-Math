/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.andrewshaomatrixmath;

/**
 *
 * @author andrewsssmario
 */
//Matrix Object Class(Implemented with multi dimensional arrays)
import java.util.*;
public class Matrix {
    private int[][] arr;
    private int width;
    private int height;
    public Matrix(int w, int h){
        //Create New Matrix
        arr = new int[w][h];
        width = w;
        height = h;
        for (int i=0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                arr[i][j] = 0;
            }
        }
    }
    private void change_digit(int w, int h, int val){
        arr[w][h] = val;
    }
    public void enter_digits(){
        //get User to fill it with numbers
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                int l = 0;
                
                String val = "";
                
                boolean valid = false;
                do{
                    System.out.println(String.format("Enter Number for Row: %d, Column: %d", i, j));
                    val = scanner.nextLine();
                    //Validate Input before continuing
                    valid = true;
                    for (int k=0; k<val.length(); k++){
                        char a = val.charAt(k);
                        if (!Character.isDigit(a) && a!='-'){
                            valid = false;
                        }
                    }
                }
                while(!valid);
                l = Integer.parseInt(val);

                //Add to Matrix
                arr[i][j] = l;
            }
        }
    }
    
    public Matrix scalar_multiplication(int scalar){
        Matrix new_matrix = new Matrix(width, height);
        for (int i=0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                new_matrix.change_digit(i, j, get_digit(i, j) * scalar);
            }
        }
        return new_matrix;
    }
    public Matrix matrix_addition(Matrix matrix){
        //Check for Valid Matrix
        if (get_width() != matrix.get_width() || get_height() != matrix.get_height()){
            System.out.println("Invalid Matrix, returning null");
            return null;
        }
        Matrix new_matrix = new Matrix(get_width(), get_height());
        for (int i=0; i<get_width(); i++){
            for (int j = 0; j<get_height();j++){
                new_matrix.change_digit(i, j, matrix.get_digit(i, j) + get_digit(i, j));
            }
        }
        return new_matrix;
    }
    public Matrix matrix_negation(){
        Matrix matrix = new Matrix(get_width(), get_height());
        for (int i=0; i<get_width(); i++){
            for (int j = 0; j<get_height(); j++){
                matrix.change_digit(i, j, -get_digit(i, j));
            }
        }
        return matrix;
    }
    public Matrix matrix_subtraction(Matrix matrix){
        //Create Negated matrix
        Matrix to_Subtract = matrix.matrix_negation();
        return matrix_addition(to_Subtract);
        //This Works Because Matrix Subtraction is Just Matrix Addition with a Negated Matrix
    }
    public Matrix matrix_multiplication(Matrix matrix){
        /*
        Matrix Multiplication
        
        (m, n) * (n, x) = (m, x) Matrix, where n must be the same
        
        */
        if (get_height() != matrix.get_width()){
            System.out.println("Invalid Matrix, Returning Null");
            return null;
        }
        Matrix new_matrix = new Matrix(get_width(), matrix.get_height());
        
        //Grab Individual Rows
        for (int i=0; i<width; i++){
            //Grab Matrix's Cols
            for (int j = 0; j<matrix.get_height(); j++){
                int total = 0;
                //N should be the same so this for loop should be legal
                for (int k = 0; k<height; k++){
                    total+= get_digit(i, k) * matrix.get_digit(k, j);
                }
                new_matrix.change_digit(i, j, total);
            }
        }
        return new_matrix;
    }
    
    public Matrix transpose(){
        Matrix new_matrix = new Matrix(get_height(), get_width());
        for (int j = 0; j<get_height(); j++){
            for (int i=0; i<get_width(); i++){
                new_matrix.change_digit(j, i, get_digit(i, j));
            }   
        }
        return new_matrix;
        
    }
    //Some Helpers
    private int get_digit(int w, int h){
        return arr[w][h];
    }
    //Getter Methods
    public int get_width(){
        return width;
    }
    public int get_height(){
        return height;
    }
    public void print_matrix(){
        //Prints User Friendly View of Matrix
        for (int i=0; i< arr.length; i++){
            for (int j = 0; j< arr[i].length; j++){
                System.out.print(String.format("%d ", arr[i][j]));
            }
            System.out.println();
        }
    }
}
