package ru.bcomms.part_01.linear_eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LinearEquation<T extends Number> {
    protected List<T> coefficients = new ArrayList<>();
    protected T free_member;

    @SafeVarargs
    public LinearEquation(T ... coefficients) {
        int numberOfCoefficients = coefficients.length - 1;
        this.coefficients
                .addAll(Arrays.asList(coefficients)
                        .subList(0, numberOfCoefficients));
        this.free_member = coefficients[numberOfCoefficients];
    }
}
