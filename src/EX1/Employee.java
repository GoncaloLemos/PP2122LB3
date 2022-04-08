package EX1;

/**
 * @author Pedro Simões & Gonçalo Lemos
 */
public class Employee extends Thread {
    /**
     * The maximum number of pieces an employee can create per shift.
     */
    static int MAX_PIECES = 5;
    /**
     * This employee's name.
     */
    public final String name;
    /**
     * The time in milliseconds it takes for this employee to complete the construction of one piece.
     */
    private final int delay;
    /**
     * The constructed pieces count.
     */
    public int pieces = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new instance of employee with a specific name and Work delay.
     *
     * @param Name  The name of the new employee.
     * @param Delay The time in milliseconds it takes for this employee to complete the construction of one piece.
     */
    public Employee(final String Name, final int Delay) {
        this.name = Name;
        this.delay = Delay;
        this.setPriority(Thread.NORM_PRIORITY);
        this.setName(Name);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Employee M = new Employee("Manuel", 3000);
        Employee P = new Employee("Pedro", 5000);
        M.start();
        P.start();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Initiates this employee's work shift. And stop it after it completes the maximum number of constructed pieces per shift.
     */
    public void run() {
        System.out.println(this.name + " [Initiated his work shift.]");
        while (pieces < MAX_PIECES) {
            try {
                Thread.sleep(delay);
                System.out.println(this.name + ": " + ++pieces);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(this.name + " [Completed his work shift.]");
    }
}
