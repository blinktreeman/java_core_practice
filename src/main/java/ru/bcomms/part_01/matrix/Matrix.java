package ru.bcomms.part_01.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с матрицами
 */
public class Matrix<T extends Number> {
    protected List<List<T>> matrix;

    public Matrix() {
        this.matrix = new ArrayList<>();
    }

    public Matrix(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    /**
     * Возвращает матрицу
     * @return матрица n x m
     */
    public List<List<T>> getMatrix() {
        return this.matrix;
    }

    /**
     * Возвращает строку матрицы
     * @param row номен строки от 0
     * @return строка матрицы в виде списка
     */
    public List<T> getRow(int row) {
        return matrix.get(row);
    }

    /**
     * Возвращает кличество строк матрицы
     * @return количество строк
     */
    public int rows() {
        return matrix.size();
    }

    /**
     * Возвращает количество столбцов матрицы
     * @return количество столбцов
     */
    public int columns() {
        return matrix.get(0).size();
    }

    /**
     * Добавление строки матрицы
     * @param row строка матрицы в виде списка
     */
    public void addRow(List<T> row) {
        matrix.add(row);
    }

    /**
     * Удаляет строку матрицы с номером row
     * @param row номер удаляемой строки от 0
     */
    public void removeRow(int row) {
        matrix.remove(row);
    }

    /**
     * Удаляет столбец матрицы с номером col
     * @param row номер удаляемого столбца от 0
     */
    public void removeColumn(int col) {
        for (int j = 0; j < columns(); j++) {
            matrix.get(j).remove(col);
        }
    }

    /**
     * Проверка квадратная ли матрица
     * @return true если матрица квадратная
     */
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
                System.out.println(this);
                minor.removeRow(0);
                minor.removeColumn(j);
                System.out.println(this);
                det += (Double) matrix.get(0).get(j) * Math.pow(-1, 1 + j + 1) * determinant();
            }
            return det;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                sb.append(matrix.get(i).get(j)).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
