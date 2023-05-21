package ru.bcomms.part_01.linear_eq;

import java.util.ArrayList;
import java.util.List;

import ru.bcomms.part_01.linear_eq.exceptions.WrongArgsNumException;
import ru.bcomms.part_01.matrix.Matrix;

public class LinearSystem<T extends Number> {
    private final Matrix<T> systemMatrix = new Matrix<>();
    private final List<T> freeMembersColumn = new ArrayList<>();

    public void addEquation(LinearEquation<T> lEquation) throws WrongArgsNumException {
        if (systemMatrix.rows() == 0 || systemMatrix.columns() == lEquation.coefficients.size()) {
            systemMatrix.addRow(lEquation.coefficients);
            freeMembersColumn.add(lEquation.free_member);
        } else {
            throw new WrongArgsNumException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < systemMatrix.rows(); i++) {
            sb.append("[ ");
            for (int j = 0; j < systemMatrix.columns(); j++) {
                sb.append(systemMatrix.getRow(i).get(j)).append(" ");
            }
            sb.append("| ").append(freeMembersColumn.get(i)).append(" ]\n");
        }
        return sb.toString();
    }
}
