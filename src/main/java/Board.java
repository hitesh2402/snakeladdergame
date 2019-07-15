import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<ISquare> squares = new ArrayList<ISquare>();
    private final int START_POSITION;
    private final int END_POSITION;

    public ISquare findSquareByPoisition(int position) {
        return squares.get(position);
    }

    public Board(int numberOfSquares, List<Transformer> snakes, List<Transformer> ladders) {

        this.START_POSITION = 1;
        this.END_POSITION = numberOfSquares;

        squares.add(new Square(0));
        for(int i = 1; i <= numberOfSquares;) {
            squares.add(new Square(i));
            i++;
        }

        ISquare firstSquare = createFirstSquare(START_POSITION);

        squares.set(START_POSITION, firstSquare);

        for(Transformer snake : snakes) {
            ISquare destination = findSquareByPoisition(snake.getTail());
            ISquare square = new SnakeOrLadderSquare(snake.getHead(), destination);
            squares.set(square.getPosition(), square);
        }

        for(Transformer ladder : ladders) {
            ISquare destination = findSquareByPoisition(ladder.getHead());
            ISquare square = new SnakeOrLadderSquare(ladder.getTail(), destination);
            squares.set(square.getPosition(), square);
        }
    }


    public int getEND_POSITION() {
        return END_POSITION;
    }

    public ISquare getFirstSquare() {
        return findSquareByPoisition(START_POSITION);
    }

    ISquare createFirstSquare(int position) {
        return new FirstSquare(position);
    }
}
