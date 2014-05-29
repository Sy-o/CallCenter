import entity.CallCenter;
import entity.Caller;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 30, 2014
 * Time: 3:26:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        CallCenter center = new CallCenter(3);
        try {
            for (int i = 0; i < 12; i++) {
                Thread.sleep(1);
                new Caller(center, i).start();
            }
        } catch (InterruptedException ex) {
            System.out.println("Error in Main thread " + Thread.currentThread());
        }
    }
}
