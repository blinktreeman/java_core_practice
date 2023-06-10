package ru.bcomms.part_03.workers;

public class TimeWorker extends Person implements Worker {
    private final double WORKING_HOURS = 20.8 * 8;
    private int hourlyRate;

    public TimeWorker(String name, String surname, String patronymic) {
        super(name, surname, patronymic);
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double payroll() {
        return this.hourlyRate * WORKING_HOURS;
    }
}
