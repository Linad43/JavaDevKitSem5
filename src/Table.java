import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Table extends Thread{
    public Table() {
        int length = 5;
        /*Philosopher philosopher[] = new Philosopher[length];
        Fork fork[] = new Fork[5];
        fork[2] =new Fork(2);*/
        ArrayList<Philosopher> philosophers = new ArrayList<Philosopher>();
        ArrayList<Fork> forks = new ArrayList<Fork>();
        for (int i = 0; i < length; i++) {
            forks.add(new Fork(i));
        }
        for (int i = 0; i < length; i++) {
            philosophers.add(new Philosopher("Философ", i, forks.get(i), forks.get(i + 1 < length ? i + 1 : i + 1 - length)));
        }
        for (int i = 0; i < length; i++) {
            philosophers.get(i).start();
        }

    }

}
