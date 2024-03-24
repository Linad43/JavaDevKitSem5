import java.util.concurrent.atomic.AtomicBoolean;

public class Fork extends Thread{
    private final int numFork;
    private transient boolean down;

    public Fork(int numFork) {
        this.numFork = numFork;
        //this.down.set(true);
        this.down = true;
    }
    /*public Fork() {
        this.numFork = 0;
        this.down.set(true);
    }*/

    public int getNumFork() {
        return numFork;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

}
