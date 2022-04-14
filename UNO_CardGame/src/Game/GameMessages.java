package Game;
import java.util.ArrayList;

import Cards.Card;
import Cards.CardColour;
import Cards.CardValue;
import Player.Player;

public class GameMessages {
    private String gameRules;
    private String welcomeMessage = "\n** Welcome to UNO Card Game! **\n";
    
    public GameMessages(){
        this.gameRules = setGameRules();
    }

    private String setGameRules(){
        String gameRules = "";
        gameRules += "The game is simple: The first player to empty their hand wins the game! Each Card has a specific colour and a specific value.\n";
        gameRules += "To play a card, it must one of have the following: \n   1. The same colour as the top card of the discard pile \n   2. The same value as the top card of the discard pile.\n\n";
        gameRules += "Some card values are special action cards with special abiltiies. There are 5 in total: WILDCOLOUR, DRAW2, DRAW4, SKIP & REVERSE.\n";
        gameRules += "   WILDCOLOUR - allows you to choose the new colour in play. \n   DRAW2 - forces the next player to add 2 cards to their hand. \n   DRAW4 - forces the next palyer to add 4 cards to their hand.\n";
        gameRules += "   SKIP - allows you to skip the next player's turn. \n   REVERSE - allows you to change the player order roation.\n\n";
        gameRules += "Cleverly play a special action card to ensure your path to success!";
        return gameRules;
    }

    public String getGameRules(){
        return this.gameRules;
    }

    public String getWelcomeMessage(){
        return this.welcomeMessage;
    }

    public void welcomePlayersMessage(ArrayList<Player> playerlist){
        System.out.println("\nWelcome! ");
        for(Player player : playerlist){
            System.out.print(player.toString() + "! ");
        }
    }

    public void gameStartingMessage(){
        System.out.println("\n\nNow creating a new Game...\n\n");
    }

    public static void declareCurrentPlayerMessage(Player player){
        System.out.println("\n***Player " + player.toString() + "'s turn***");
    }

    public void currentPlayerHandSize(Player player){
        System.out.println("Number of Cards in your hand: " + player.getPlayerHand().getPlayerHandSize());
    }

    public void currentPlayerPlayableCardsMessage(Player player, Card topCard){
        System.out.println("\nPlayable Cards in your hand: ");
        player.getPlayerHand().playableCards(topCard);
    }

    public void quitGameMessage(){
        String quitGame = "";
        quitGame += "\n////////////////////////////////////////////\n";
        quitGame += "////////////////////////////////////////////\n";
        quitGame += "\n\tPlayer has quit the game. \n\tGAME IS NOW OVER.\n";
        quitGame += "\n////////////////////////////////////////////\n";
        quitGame += "////////////////////////////////////////////\n";
        System.out.println(quitGame);
    }

    public void playerHasEmptyHandMessage(Player player){
        System.out.println("Player " + player.toString() + " has emptied their hand!");
        System.out.println("Congratulations Player " + player.toString() + "! You won the game!");
    }

    public void displayTopCardMessage(CardColour topCardColour, CardValue topCardValue){
        System.out.println("Current Top Card: " + topCardColour + " - " + topCardValue+"\n\n=====================================");
    }

    public void displayCannotPlayCard(){
        System.out.println("- - Invalid card chosen. Please select another card.");
    }

    public void displayPlayerPosition(){
        System.out.print("\nType the position number of the card you want to play or type '-1' to exit the game: ");
    }

    public void displayNoPlayableCards(){
        System.out.print("\nNo Playable Cards in your hand. Type 'DRAW' to draw a card or type -1 to exit the game: ");
    }

    public void displayInValidInputForDraw(){
        System.out.println("Invalid Input! Please type 'DRAW' to draw a card.");
    }

    public void playerDrewACard(Player player){
        System.out.println("Player " + player.toString() + " has drawn a card.");
        System.out.println("=====================================");
    }


}
