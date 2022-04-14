package Util;
import java.util.ArrayList;

import Player.Player;

public class Signup {
  private String name;
  private int numberOfPlayers;
  public ArrayList<Player> playerlist = new ArrayList<Player>();
  UserInput userInput = new UserInput();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Player> getPlayerlist() {
    return playerlist;
  }

  public void setPlayerlist(ArrayList<Player> playerlist) {
    this.playerlist = playerlist;
  }

  public int getNumberOfPlayers(){
    return numberOfPlayers;
  }

  public void signUpSession(){
    System.out.println("Okay! Let's get set up! This game needs 2-4 players to begin\n");
    while(true){
      userInput.askNumberOfPlayers();
      userInput.setNumberOfPlayers();

      int numOfPlayers = userInput.getNumberOfPlayers();
      if(numOfPlayers > 1 && numOfPlayers < 5){
          for (int i=0; i<numOfPlayers; i++){
              System.out.print("Enter player #" +(i+1) + " name: ");
              userInput.setNameOfPlayers();
              String nameInput = userInput.getNameOfPlayers();
              playerlist.add(new Player(nameInput));
          }
  
          System.out.print("\nWelcome! ");
          for(Player player : playerlist){
              System.out.print(player.toString() + ". ");
          }
          System.out.println(" ");
          break;
      }  else {
          System.out.println("Error. Only put 2-4 players");
          userInput.askNumberOfPlayers();
          userInput.setNumberOfPlayers();
          numOfPlayers = userInput.getNumberOfPlayers();
      }
  }
  }
}
