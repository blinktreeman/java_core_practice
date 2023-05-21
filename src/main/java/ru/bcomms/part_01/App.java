package ru.bcomms.part_01;

import ru.bcomms.part_01.linear_eq.LinearEquation;
import ru.bcomms.part_01.linear_eq.LinearSystem;

public class App {
    public static void main(String[] args) {
        LinearEquation le1 = new LinearEquation(1, 0, 0);
        System.out.println(le1);
        LinearEquation le2 = new LinearEquation(-1.0, -2.0, -3.0, -4.0);
        System.out.println(le2);
        LinearSystem lSystem = new LinearSystem();
        lSystem.addEquation(le1);
        lSystem.addEquation(le2);
        System.out.println(lSystem);
    }
}
