package ru.bcomms.part_03.workers;

public abstract class Person implements Comparable<Person> {
    private final String name;
    private final String surname;
    private final String patronymic;
    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname =surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Сортировка по фамилии
     * @param person the object to be compared.
     * @return результат сравнения
     */
    @Override
    public int compareTo(Person person) {
        return this.surname.compareTo(person.getSurname());
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic;
    }
}
