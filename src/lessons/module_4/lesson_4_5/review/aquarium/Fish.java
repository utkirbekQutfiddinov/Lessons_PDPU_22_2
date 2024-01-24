package lessons.module_4.lesson_4_5.review.aquarium;

import java.util.Random;

public class Fish implements Runnable {
    private boolean alive;
    private long lifeDuration;
    private long birthTime;
    private long lastBreedTime;
    private boolean male;
    private boolean adult;
    private boolean canBreed;
    private static Random rand = SingletonRandom.getInstance();

    private int x;
    private int y;
    private int z;

    public Fish() {
        lifeDuration = rand.nextLong(1000, 5000);
        birthTime = System.currentTimeMillis();
        male = rand.nextBoolean();
        adult = false;
        alive = true;
        x = rand.nextInt(1,10);
        y = rand.nextInt(1,10);
        z = rand.nextInt(1,10);

    }

    @Override
    public void run() {
        while (System.currentTimeMillis() < birthTime + lifeDuration) {
            if (System.currentTimeMillis() >= (birthTime + lifeDuration)) {
                alive = false;
            }
            if (System.currentTimeMillis() >= (birthTime + lifeDuration / 5)) {
                adult = true;
            }

            if (!canBreed && System.currentTimeMillis() > (lastBreedTime + lifeDuration / 5)) {
                canBreed = true;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            x = rand.nextInt(rand.nextInt(1, 10));
            y = rand.nextInt(rand.nextInt(1, 10));
//            z = rand.nextInt(rand.nextInt(1, 100));
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public long getLifeDuration() {
        return lifeDuration;
    }

    public void setLifeDuration(long lifeDuration) {
        this.lifeDuration = lifeDuration;
    }

    public long getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(long birthTime) {
        this.birthTime = birthTime;
    }

    public long getLastBreedTime() {
        return lastBreedTime;
    }

    public void setLastBreedTime(long lastBreedTime) {
        this.lastBreedTime = lastBreedTime;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isCanBreed() {
        return canBreed;
    }

    public void setCanBreed(boolean canBreed) {
        this.canBreed = canBreed;
    }

    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        Fish.rand = rand;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
