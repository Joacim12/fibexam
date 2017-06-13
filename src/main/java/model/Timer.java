package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;

/**
 *
 * @author Joacim
 */
public class Timer extends Observable {

    private DateFormat dateFormat;
    private Calendar cal;
    private String current;
    private boolean running = false;

    public Timer() {
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        cal = Calendar.getInstance();
    }

    public void getTime() {
        current = dateFormat.format(Calendar.getInstance().getTime());
        setChanged();
        notifyObservers(current);
    }
}
