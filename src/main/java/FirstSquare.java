import java.util.ArrayList;
import java.util.List;

public class FirstSquare extends Square{

    List<Player> players = new ArrayList<Player>();

    @Override
    public void remove(Player player) {
        players.remove(player);
    }

    @Override
    public void add(Player player) {
        System.out.println(String.format("%s reached %s", player.getName(), position));
        players.add(player);
        player.setCurrentSquare(this);
    }

    public FirstSquare(int position) {
        super(position);
    }
}
