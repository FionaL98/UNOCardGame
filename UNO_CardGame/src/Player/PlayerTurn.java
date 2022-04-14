package Player;

import java.util.ArrayList;
import java.util.Random;

public class PlayerTurn {
    private ArrayList<Player> players;
    
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void showPlayerOrder(){
        System.out.println("Player Turn Order: ");
        for (Player player : players){
            System.out.println(player.toString());
        }
    }

    public void randomizePlayerOrder(){
        Random r = new Random();
        for (int i=players.size() - 1; i > 0; i--){
            int pick = r.nextInt(i);
            Player random = players.get(pick);
            Player last = players.get(i);
            players.set(i, random);
            players.set(pick, last);
        }
    }
}
