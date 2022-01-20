package org.coderslab.errors;

public class Error2 {

    public static Integer constValue;

    public static void main(String[] args) {

        Integer integer = 123;
        int result = multiplyByConst(integer);
        System.out.println(result);

    }

    public static int multiplyByConst(Integer integer){
        return constValue * integer;
    }
}
