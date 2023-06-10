package ru.bcomms.part_03.workers;

public class PermanentWorker extends Person implements Worker {
    private double fixedMonthlyPayment;
    public PermanentWorker(String name, String surname, String patronymic) {
        super(name, surname, patronymic);
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    @Override
    public double payroll() {
        return this.fixedMonthlyPayment;
    }
}
