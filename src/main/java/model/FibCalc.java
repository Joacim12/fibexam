package model;

import java.util.Observable;

/**
 *
 * @author Joacim
 */
public class FibCalc extends Observable {

    private long calculateFibonacci(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    public void getFib(int n) {
        Long l = calculateFibonacci(n);
        setChanged();
        notifyObservers(l);
    }
}