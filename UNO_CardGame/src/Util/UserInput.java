package Util;
import java.util.Scanner;

public class UserInput {
  Scanner scanner = new Scanner(System.in);
  int numberOfPlayers;
  String nameOfPlayers;
  int numInputForPosition;
  String typeDraw;
  String changeWildCardColour;


  public void askNumberOfPlayers(){
    System.out.print("How many players are playing this game? ");
  }

  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }
  
  public void setNumberOfPlayers() {
    numberOfPlayers = scanner.nextInt();
  }

  public String getNameOfPlayers(){
    return nameOfPlayers;
  }

  public void setNameOfPlayers(){
    nameOfPlayers = scanner.next();
  }

  public void setNumInputForPosition(){
    numInputForPosition = scanner.nextInt();
  }

  public int getNumInputForPosition(){
    return numInputForPosition;
  }

  public void setTypeDraw(){
    typeDraw = scanner.next();
  }

  public String getTypeDraw(){
    return typeDraw;
  }

  public void setChangeWildCardColour(){
    changeWildCardColour = scanner.next();
  }

  public String getWildCardColour(){
    return changeWildCardColour;
  }

}


