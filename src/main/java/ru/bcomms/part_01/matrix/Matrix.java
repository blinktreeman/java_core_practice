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

    public List<List<T>> getMatrix() {
        return this.matrix;
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

    public void removeRow(int row) {
        matrix.remove(row);
    }

    public void removeColumn(int col) {
        for (int j = 0; j < columns(); j++) {
            matrix.get(j).remove(col);
        }
    }

    public boolean isQuadratic() {
        return rows() == columns();
    }

    /**
     * Определение детерминанта матрицы разложением по строке
     * 
     * @return определитель матрицы
     */
    public Double determinant() {
        /*
         * Определение детерминанта матрицы разложением по строке:
         * 
         * Определитель матрицы - сумма для j-х элементов строки (-1)^1+j * aj * Mj
         * где Mj - дополнительный минор к элементу aj
         * Рекурсивно выполняем до размера матрицы 1х1
         */
        if (matrix.size() == 1) {
            return (Double) matrix.get(0).get(0);
        } else {
            Double det = 0.0;
            for (int j = 0; j < columns(); j++) {
                // Для нахождения минора передаем в конструктор исходную матрицу
                Matrix<T> minor = new Matrix<>(matrix);
                // Удаляем из исходной матрицы j-тый столбец, строку 0 (разложение по первой
                // строке)
                minor.removeRow(0);
                minor.removeColumn(j);
                det += (Double) matrix.get(0).get(j) * Math.pow(-1, 1 + j + 1) * determinant();
            }
            return det;
        }
    }
}
