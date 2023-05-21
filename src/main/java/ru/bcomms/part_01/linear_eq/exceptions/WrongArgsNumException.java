package ru.bcomms.part_01.linear_eq.exceptions;

public class WrongArgsNumException extends Exception {
    public WrongArgsNumException() {
        super("The number of coefficients for variables does not"
                + " correspond to the matrix of the system");
    }
}
