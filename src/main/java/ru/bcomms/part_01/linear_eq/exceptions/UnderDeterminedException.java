package ru.bcomms.part_01.linear_eq.exceptions;

public class UnderDeterminedException extends Exception {
    public UnderDeterminedException() {
        super("Under-determined system");
    }
}
