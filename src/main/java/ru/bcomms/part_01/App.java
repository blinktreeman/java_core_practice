package ru.bcomms.part_01;

import ru.bcomms.part_01.linear_eq.LinearEquation;
import ru.bcomms.part_01.linear_eq.LinearSystem;
import ru.bcomms.part_01.linear_eq.exceptions.WrongArgsNumException;

public class App {
    public static void main(String[] args) {
        LinearEquation<Integer> le1 = new LinearEquation<>(1, 0, 0, 1);
        LinearEquation<Integer> le2 = new LinearEquation<>(0, 1, 0, 1);
        LinearEquation<Integer> le3 = new LinearEquation<>(0, 0, 1, 1);
        LinearSystem<Integer> lSystem = new LinearSystem<>();
        try {
            lSystem.addEquation(le1);
            lSystem.addEquation(le2);
            lSystem.addEquation(le3);
        }
        catch (WrongArgsNumException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(lSystem);
    }
}
