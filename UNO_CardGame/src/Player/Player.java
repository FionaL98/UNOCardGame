package Player;

public class Player {
    private String name;
    PlayerHand playerHand;

    public Player(String name){
        this.name = name;
        this.playerHand = new PlayerHand();
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name;
    }

}
