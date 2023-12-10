package org.example;

public class Fibonacci {

    public static int getValue(int element) {
        if (element == 0) return 0;
        if (element == 1) return 1;

        return getValue(element-1) + getValue(element-2);

        /*
        int n1 = 0;
        int n2 = 1;
        int n = 0;
        while (element >= 2) {
            n = n1 + n2;
            n1 = n2;
            n2 = n;
            element--;
        }

        return n;
        */
    }

}
