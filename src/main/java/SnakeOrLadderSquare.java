public class SnakeOrLadderSquare extends Square {

    ISquare destination;

    SnakeOrLadderSquare(int position, ISquare destination) {
        super(position);
        this.destination = destination;
    }

    @Override
    public void add(Player player) {
        System.out.println("Snake or Ladder found at position " + position);
        destination.add(player);
    }
}
