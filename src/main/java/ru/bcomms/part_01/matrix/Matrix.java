package ru.bcomms.part_01.matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends Number> {
    protected List<List<T>> matrix;

    public Matrix() {
        this.matrix = new ArrayList<>();
    }

    public Matrix(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    public List<T> getRow(int row) {
        return matrix.get(row);
    }

    public int rows() {
        return matrix.size();
    }

    public int columns() {
        return matrix.get(0).size();
    }

    public void addRow(List<T> row) {
        matrix.add(row);
    }

    public boolean isQuadratic() {
        return rows() == columns();
    }

    public T determinant() {

        return null;
    }
}
