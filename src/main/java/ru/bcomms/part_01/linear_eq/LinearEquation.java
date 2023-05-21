package ru.bcomms.part_01.linear_eq;

import java.util.ArrayList;
import java.util.List;


public class LinearEquation<T extends Number> {
    protected List<T> coefficients = new ArrayList<>();
    protected T free_member;

    public LinearEquation(T ... coefficients) {
        int numberOfCoeff = coefficients.length - 1;
        for (int i = 0; i < numberOfCoeff; i++) {
            this.coefficients.add(coefficients[i]);
        }
        this.free_member = coefficients[numberOfCoeff];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.coefficients.size(); i++) {
            T c = coefficients.get(i);
            if (c < 0) {
                sb.append("(").append(coefficients.get(i)).append(")");
            }
            else {
                sb.append(coefficients.get(i));
            }
            sb.append(" * x").append(i + 1).append(" + ");
        }
        if (this.free_member < 0) {
            sb.append("(").append(this.free_member).append(")");
        }
        sb.append(" = 0");
        return sb.toString();
    }
}
