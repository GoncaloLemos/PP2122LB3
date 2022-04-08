package EX4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Pedro Simões & Gonçalo Lemos
 */
public class TestEmployees {
    public static void main(String[] args) {
        Employee M = new Employee("Manuel", 3000);
        Employee P = new Employee("Pedro", 5000);
        M.work();
        P.work();
        Timer killTimer = new Timer();
        killTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                M.stop();
                P.stop();
                killTimer.cancel();
                if (M.pieces > P.pieces) System.out.println("Manuel produced more pieces than Pedro.");
                else if (M.pieces < P.pieces) System.out.println("Pedro produced more pieces than Manuel.");
                else System.out.println("Manuel and Pedro produced the same amount of pieces.");
            }
        }, 60 * 60 * 1000);
    }
}
