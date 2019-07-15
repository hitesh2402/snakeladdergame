public class Square implements ISquare {

    Player currentPlayer;
    int position;

    public Square(int position) {
        this.position = position;
    }

    public void remove(Player player) {
        assert currentPlayer == player;
        currentPlayer = null;
    }

    public void add(Player player) {
        System.out.println(String.format("%s reached %s", player.getName(), position));
        currentPlayer = player;
        player.setCurrentSquare(this);
    }

    public int getPosition() {
        return position;
    }

    public boolean isOccupied() {
        return currentPlayer != null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
