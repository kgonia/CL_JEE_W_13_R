package org.coderslab.errors.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Error2 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        removeOddFromList(integers);

    }

    /**
     * Usuwa nieparzyste liczby z listy
     */
    public static void removeOddFromList(List<Integer> numbers){
        for (Integer currentValue : numbers) {
            System.out.println(currentValue);
            if(currentValue % 2 == 1) {
                numbers.remove(currentValue);
            }
        }
    }
}
