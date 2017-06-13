package control;

import java.util.Observer;
import model.FibCalc;
import model.Timer;

/**
 *
 * @author Joacim
 */
public class Control {

    Timer timer = new Timer();
    FibCalc fibCalc = new FibCalc();

    public void timerAddObserver(Observer o) {
        timer.addObserver(o);
    }

    public void fibAddObserver(Observer o) {
        fibCalc.addObserver(o);
    }

    public void getTime() {
        timer.getTime();
    }

    public void getFibResult(int n) {
        fibCalc.getFib(n);
    }

}