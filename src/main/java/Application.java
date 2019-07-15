import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {

        Player hitesh = new Player("Hitesh");
        Player lama = new Player("Lama ji");

        Queue<Player> players = new LinkedList<Player>();
        players.add(hitesh);
        players.add(lama);

        List<Transformer> snakes = new ArrayList<Transformer>();
        List<Transformer> ladders = new ArrayList<Transformer>();

        ladders.add(new Transformer(21, 2));
        ladders.add(new Transformer(7, 4));
        ladders.add(new Transformer(25, 10));
        ladders.add(new Transformer(28, 19));

        snakes.add(new Transformer(26, 5));
        snakes.add(new Transformer(20, 8));
        snakes.add(new Transformer(16, 3));
        snakes.add(new Transformer(18, 6));

        Board board = new Board(30, snakes, ladders);
        Dice dice = new Dice();
        Game game = new Game(players, board, dice);
        game.start();
    }
}
