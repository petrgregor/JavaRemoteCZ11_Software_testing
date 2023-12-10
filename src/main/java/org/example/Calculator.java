package org.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator extends Throwable {

    private Integer result;

    public int add(int first, int second) {
        this.result = first + second;
        return this.result;
    }

    public int multiply(int first, int second) {
        this.result = first * second;
        return this.result;
    }

    public double divide(double first, double second) {
        if (second == 0) throw new IllegalArgumentException();
        return first / second;
    }

    public void delete_result() {
        this.result = null;
    }

    public Integer get_result() {
        return this.result;
    }

    public boolean is_even(int number) {
        return number % 2 == 0;
    }

    // najde rozklad na prvočinitele
    // 12 -> 2, 2, 3
    public List<Integer> prime_factorization(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> prime_factors = new ArrayList<>();
        int divider = 2;
        while (number > 1) {
            if (number % divider == 0) {
                prime_factors.add(divider);
                number /= divider;
            } else {
                divider++;
            }
        }
        return prime_factors;
    }

}
