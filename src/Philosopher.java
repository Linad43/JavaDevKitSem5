public class Philosopher extends Thread {
    private final String name;
    private int numName;
    private boolean ifEat;
    private boolean end;
    private int countEat;
    Fork leftFork;
    Fork rightFork;
    public Philosopher(String name, int numName, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.numName = numName;
        this.ifEat = false;
        this.end = false;
        this.countEat = 0;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
    public void eating () throws InterruptedException {
        if (leftFork.isDown() && rightFork.isDown() && !ifEat){
            leftFork.setDown(false);
            rightFork.setDown(false);
            ifEat = true;
            System.out.println("Философ " + numName + " ест (" + ++countEat + ") вилками " + leftFork.getNumFork() + " и " + rightFork.getNumFork());
            sleep((long) (Math.random()*900+100));
        }
        else {
            ifEat = false;
            leftFork.setDown(true);
            rightFork.setDown(true);
            System.out.println("Философ " + numName + " думает");
            sleep((long) (Math.random()*900+100));
        }
    }

    public int getNumName() {
        return numName;
    }

    public boolean isIfEat() {
        return ifEat;
    }

    @Override
    public void run() {
        while (countEat<4) {
            try {
                eating();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Философ " + numName + " наелся");
    }
}
