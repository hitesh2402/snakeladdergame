public interface ISquare {

    void remove(Player player);
    void add(Player player);
    int getPosition();
    boolean isOccupied();
    Player getCurrentPlayer();
}
