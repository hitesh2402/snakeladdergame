public class Player {

    private final String name;
    private ISquare currentSquare;

    public Player(String name) {
        this.name = name;
    }

    public void setCurrentSquare(ISquare currentSquare) {
        this.currentSquare = currentSquare;
    }

    public ISquare getCurrentSquare() {
        return currentSquare;
    }

    public String getName() {
        return name;
    }
}
