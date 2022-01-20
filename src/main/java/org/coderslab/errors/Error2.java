package org.coderslab.errors;

public class Error2 {

    public static Integer constValue = 10;

    public static void main(String[] args) {

        Integer integer = 123;
        int result = multiplyByConst(integer);
        System.out.println(result);

    }

    public static int multiplyByConst(Integer integer) {
        if (constValue != null) {
            return constValue * integer;
        } else {
            return integer;
        }
    }
}
