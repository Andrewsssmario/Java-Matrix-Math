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
/*
Andrew Shao Matrix Math Program

Effectively, I will create a set of methods for Matrix Objects, Scalar Multiplication, Matrix Subtraction, Matrix Addition

These Matrices will operate on 2D Arrays and Scalars

Operations:

Transposition(3,2) -> (2, 3)

Multiplication(Dot Product)

Scalar Multiplication

Addition

Subtraction

*/
import java.util.*;

public class App {
    public static void main(String [] args){
        //Test Some Of The Methods!
        Sample();
    }
    public static void Sample(){
        //Sample Usage of The Matrix Class
        Matrix m = new Matrix(2, 3);
        m.enter_digits();
        //Tranposes to Matrix(3, 2), Then multiplies the two matrixes
        Matrix n = m.transpose();
        n.matrix_multiplication(m).print_matrix();
        /*
        Results:
        1 2 3 -> 1 4  * 1 2 3   17 22 27
        4 5 6    2 5    4 5 6 = 22 29 36
                 3 6            27 36 45
        */
    }
    public static void Test(){
        /*
        Addition
        1  2 + 5  6  = 6  8
        3  4   7  8    10  12
        Subtraction 
        
        3  8   -    4  0        -1   8
        4  6        1  -9   =    3    15
        */
        /*
        Sample test case for reg multiplication
        
        4 0         8 0
        1 -9   *2 = 2 -18
        */
        
        /*
        Sample Test Cases For Matrix Multiplication
        First Matrix
        1  2  3    *   7  8                58   64
        4  5  6        9  10       =       139  154
                       11 12  
        */
        
        
    }
}
