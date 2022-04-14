package Game;
import java.util.ArrayList;

import Cards.CardColour;
import Decks.DiscardPile;
import Decks.DrawPile;
import Player.Player;
import Util.UserInput;

public class ActionCardController {
    UserInput userInput = new UserInput();

    /**
     * Reverse ActionCard Method
     * @param gameDirection
     * @return
     */
    public boolean reverseAction(boolean gameDirection){
        System.out.println("** SPECIAL ACTION: Player Turn Order is now reversed.");
        if (gameDirection == true){
            gameDirection = false;
        } else {
            gameDirection = true;
        }
        return gameDirection;
    }

    /**
     * Skip ActionCard Method
     * @param gameDirection
     * @param currentPlayerIndex
     * @param playerlist
     */
    protected void skipAction(boolean gameDirection, int currentPlayerIndex, ArrayList<Player> playerlist){
        if (gameDirection = true) {
            if (currentPlayerIndex == playerlist.size() -1){
                int nextPlayer = 0;
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + "'s turn was skipped");
            } else {
                int nextPlayer = currentPlayerIndex + 1;
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + "'s turn was skipped");
            }
        }

        if (gameDirection == false){
            if (currentPlayerIndex == 0){
                int nextPlayer = playerlist.size() - 1;
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + "'s turn was skipped");
            } else {
                int nextPlayer = currentPlayerIndex -1;
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + "'s turn was skipped");
            }
        }
    }

    /**
     * DrawFour ActionCard Method
     */
    protected void drawFourAction(boolean gameDirection, int currentPlayerIndex, ArrayList<Player> playerlist, DrawPile drawPile){
        if (gameDirection == true){
            if(currentPlayerIndex == (playerlist.size() - 1)){
                int nextPlayer = 0;
                for (int i=0; i<4; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 4 cards")
                ;
            } else {
                int nextPlayer = currentPlayerIndex + 1;
                for (int i=0; i<4; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 4 cards");
            }   
        } 

        if (gameDirection == false){
            if (currentPlayerIndex == 0){
                int nextPlayer = playerlist.size() - 1;
                for (int i=0; i<4; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 4 cards");
            } else {
                int nextPlayer = currentPlayerIndex -1;
                for (int i=0; i<4; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 4 cards");
            }
        }
    }

    /**
     * DrawTwo ActionCard Method
     */
    protected void drawTwoAction(boolean gameDirection, int currentPlayerIndex, ArrayList<Player> playerlist, DrawPile drawPile){
        if (gameDirection == true){
            if(currentPlayerIndex == (playerlist.size() - 1)){
                int nextPlayer = 0;
                for (int i=0; i<2; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 2 cards");
            } else {
                int nextPlayer = currentPlayerIndex + 1;
                for (int i=0; i<2; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 2 cards");
            }   
        } 

        if (gameDirection == false){
            if (currentPlayerIndex == 0){
                int nextPlayer = playerlist.size() - 1;
                for (int i=0; i<2; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 2 cards");
            } else {
                int nextPlayer = currentPlayerIndex -1;
                for (int i=0; i<2; i++){
                    playerlist.get(nextPlayer).getPlayerHand().addCard(drawPile.drawCard());
                }
                System.out.println("** SPECIAL ACTION: Player " + playerlist.get(nextPlayer).toString() + " has drawn 2 cards");
            }
        }
    }

    /**
     * WildColour ActionCard Method
     */
    protected CardColour wildColourAction(CardColour topCardColour, DiscardPile discardPile){
        String colour = askPlayerForChosenColour();
        topCardColour = CardColour.valueOf(colour);
        discardPile.wildcolourChangeCardColour(CardColour.valueOf(colour));
        return topCardColour;
    }

    public String askPlayerForChosenColour(){
        System.out.println("** SPECIAL ACTION: Choose a colour to change to: ");
        System.out.print("BLUE, RED, GREEN, YELLOW: ");
        userInput.setChangeWildCardColour();
        String chosenColour = userInput.getWildCardColour().toUpperCase();
        return chosenColour;
    }

}
