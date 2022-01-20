package org.coderslab.errors;

public class Error3 {

    public static void main(String args[]) {
        int x = 1;
        int y = 10;
        try {
            int z = y / x;
        } catch (ArithmeticException e){
            //jakis kod
        }
    }

}
