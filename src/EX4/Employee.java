package EX4;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Employee {
    /**
     * The maximum number of pieces an employee can create per shift.
     */
    static int MAX_PIECES = Integer.MAX_VALUE;
    /**
     * This employee's name.
     */
    public final String name;
    /**
     * The time in milliseconds it takes for this employee to complete the construction of one piece.
     */
    public final int delay;
    /**
     * The timer that controls the employee's shift.
     */
    private final Timer mainTimer = new Timer(true);
    /**
     * The constructed pieces count.
     */
    public int pieces = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new instance of employee with a specific name and work delay.
     *
     * @param Name  The name of the new employee.
     * @param Delay The time in milliseconds it takes for this employee to complete the construction of one piece.
     */
    public Employee(final String Name, final int Delay) {
        this.name = Name;
        this.delay = Delay;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Initiates this employee's work shift. And stop it after it completes the maximum number of constructed pieces per shift.
     */
    public void work() {
        mainTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (pieces == 0) System.out.println(name + " has initiated his work.");
                System.out.println(name + ": " + ++pieces);
                if (pieces >= Employee.MAX_PIECES) {
                    mainTimer.cancel();
                    System.out.println(name + " has ended his work.");
                }
            }
        }, new Date(), delay);
    }

    /**
     * Stops this employee's work shift.
     */
    public void stop() {
        mainTimer.cancel();
    }
}
