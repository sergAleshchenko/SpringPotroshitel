package quoters;

/**
 * @author Sergei Aleshchenko
 * @project SpringPotroshitel
 */
public class T1000 extends TerminatorQuoter implements Quoter {

    @Override
    public void sayQuote() {
        System.out.println("Я ЖИДКИЙ");
    }
}
