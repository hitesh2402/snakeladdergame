
import java.util.LinkedList;
import java.util.Queue;

public class Game {

    Queue<Player> players = new LinkedList<Player>();
    Board board;
    Dice dice;
    Player winner;

    public Game(Queue<Player> players, Board board, Dice dice) {
        this.players = players;
        this.board = board;
        this.dice = dice;
    }

    Player currentPlayer() {
        return players.peek();
    }

    boolean isGameOver() {
        return winner != null;
    }

    void makeNextturn() {
        Player player = players.remove();
        System.out.println(String.format("%s is taking his turn, he is at position %s", player.getName(), player.getCurrentSquare().getPosition()));
        players.add(player);
        int moves = dice.roll();
        System.out.println(String.format("%s rolled the dice and it is %s", player.getName(), moves));
        if(player.getCurrentSquare().getPosition() + moves > board.getEND_POSITION()) {
            System.out.println("No Move possible");
            return;
        }
        ISquare nextSquare = board.findSquareByPoisition(player.getCurrentSquare().getPosition() + moves);
        player.getCurrentSquare().remove(player);

        if(nextSquare.isOccupied()) {
            Player playerAlreadyPresent = nextSquare.getCurrentPlayer();
            System.out.println(String.format("%s ne %s ki goti kati", player.getName(), playerAlreadyPresent.getName()));
            nextSquare.remove(playerAlreadyPresent);
            board.getFirstSquare().add(playerAlreadyPresent);
        }

        nextSquare.add(player);
        if(player.getCurrentSquare().getPosition() == board.getEND_POSITION()) {
            System.out.println(String.format("%s won the game", player.getName()));
            winner = player;
        }
    }

    void intialize() {
        for(Player player : players) {
            ISquare square = board.getFirstSquare();
            square.add(player);
        }
    }

    void start() {
        intialize();
        while(!isGameOver()) {
            makeNextturn();
        }
    }
}
