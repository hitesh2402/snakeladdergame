import java.util.Random;

public class Dice {

    Random random = new Random();
    static int MIN_VALUE = 1;
    static int MAX_VALUE = 6;

    public int roll() {
        return random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE ;
    }
}
