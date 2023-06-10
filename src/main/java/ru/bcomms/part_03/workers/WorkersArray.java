package ru.bcomms.part_03.workers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class WorkersArray implements Iterable<Worker> {
    private Worker[] workers;

    public WorkersArray(Worker worker) {
        this.workers = new Worker[] {worker};
    }

    /*
    В задании именно массив, реализуем добавление элемента к массиву
     */
    public void addWorker(Worker worker) {
        Worker[] temp = new Worker[this.workers.length + 1];
        System.arraycopy(workers, 0, temp, 0, workers.length);
        temp[workers.length] = worker;
        this.workers = temp;
    }

    @Override
    public Iterator<Worker> iterator() {
        return new WorkerIterator();
    }

    @Override
    public void forEach(Consumer<? super Worker> action) {
        Iterable.super.forEach(action);
    }

    // Реализуем итератор
    private class WorkerIterator implements Iterator<Worker> {
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < workers.length;
        }

        @Override
        public Worker next() {
            if(current>= workers.length) {
                throw new NoSuchElementException();
            }
            return workers[current++];
        }
    }
}
