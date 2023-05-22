package ru.bcomms.part_01;

import java.util.ArrayList;
import java.util.List;

import ru.bcomms.part_01.linear_eq.LinearEquation;
import ru.bcomms.part_01.linear_eq.LinearSystem;
import ru.bcomms.part_01.linear_eq.exceptions.UnderDeterminedException;
import ru.bcomms.part_01.linear_eq.exceptions.WrongArgsNumException;

public class App {
    public static void main(String[] args) {
        LinearEquation<Double> le1 = new LinearEquation<>(1.0, 0.0, 0.0, 1.0);
        LinearEquation<Double> le2 = new LinearEquation<>(0.0, 1.0, 0.0, 1.0);
        LinearEquation<Double> le3 = new LinearEquation<>(0.0, 0.0, 1.0, 1.0);
        LinearSystem<Double> lSystem = new LinearSystem<>();
        try {
            lSystem.addEquation(le1);
            lSystem.addEquation(le2);
            lSystem.addEquation(le3);
        } catch (WrongArgsNumException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(lSystem);

        List<Double> roots = new ArrayList<>();
        try {
            roots = lSystem.getRoots();
        }
        catch (UnderDeterminedException e) {
            System.err.println(e.getMessage());
        }
        for (Double root : roots) {
            System.out.println(root);
        }
    }
}
