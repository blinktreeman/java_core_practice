/*
1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников
с почасовой оплатой (один из потомков) и фиксированной оплатой (второй потомок).
а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова:
«среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
для работников с фиксированной оплатой
«среднемесячная заработная плата = фиксированная месячная оплата».
б) Создать на базе абстрактного класса массив сотрудников и заполнить его.
в) ** Реализовать интерфейсы для возможности сортировки массива
(обратите ваше внимание на интерфейсы Comparator, Comparable)
г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность
вывода данных с использованием foreach.
 */
package ru.bcomms.part_03;

import ru.bcomms.part_03.workers.PermanentWorker;
import ru.bcomms.part_03.workers.TimeWorker;
import ru.bcomms.part_03.workers.Worker;
import ru.bcomms.part_03.workers.WorkersArray;

import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        // Работники
        PermanentWorker pw = new PermanentWorker("Ivan", "Ivanov", "Ivanovich");
        pw.setFixedMonthlyPayment(100000);
        TimeWorker tw = new TimeWorker("Pyotr", "Petrov", "Petrovich");
        tw.setHourlyRate(1000);

        Worker[] workers = new Worker[]{pw, tw};
        Arrays.sort(workers);
        System.out.println("Список работников:");
        Arrays.stream(workers)
                .map(w -> w.toString() + " salary " + w.payroll())
                .forEach(System.out::println);

        System.out.println("\nСортируем в обратном порядке:");
        Arrays.sort(workers, Collections.reverseOrder());
        Arrays.stream(workers)
                .map(w -> w.toString() + " salary " + w.payroll())
                .forEach(System.out::println);

        // Работа с итератором
        WorkersArray workersArray = new WorkersArray(pw);
        workersArray.addWorker(tw);
        System.out.println("\nСписок из класса WorkerArray:");
        // Используем foreach
        for (Worker worker : workersArray) {
            System.out.println(worker + " salary " + worker.payroll());
        }
    }
}

/*
Output:

Список работников:
Ivanov Ivan Ivanovich salary 100000.0
Petrov Pyotr Petrovich salary 166400.0

Сортируем в обратном порядке:
Petrov Pyotr Petrovich salary 166400.0
Ivanov Ivan Ivanovich salary 100000.0

Список из класса WorkerArray:
Ivanov Ivan Ivanovich salary 100000.0
Petrov Pyotr Petrovich salary 166400.0
 */