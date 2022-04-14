package Player;

import java.util.ArrayList;
import Cards.Card;

public class PlayerHand {
    private ArrayList<Card> playerHandCards = new ArrayList<Card>();

    public PlayerHand(){
    }
    public void addCard(Card card){
        this.playerHandCards.add(card);
    }

    public void removeCard(Card card){
        this.playerHandCards.remove(card);
    }

    public void showHand(){
        int count = 0;
        for (Card cards : playerHandCards){
            System.out.println(count + ". " + cards.toString());
            count++;
        }
    }

    public int getPlayerHandSize(){
        return this.playerHandCards.size();
    }

    //find out if player has any card that they can play
    public boolean canPlayACard(Card topCard){
        for (Card card : playerHandCards){
            if (topCard.getCardColour() == card.getCardColour() || topCard.getCardValue() == card.getCardValue()){
                return true;
            }
        }    
        return false;
    }

    //adds playable cards to arraylist for player to choose from
    public void playableCards(Card topCard){
        int index;
        for (Card card : playerHandCards){
            if (topCard.getCardColour() == card.getCardColour() || topCard.getCardValue() == card.getCardValue()){
                index = playerHandCards.indexOf(card);
                System.out.println(card.toString() + " (position: " + index + ")");
            }
        }    
    }

    public ArrayList<Card> getPlayerHandCards() {
        return playerHandCards;
    }

    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHandCards = playerHand;
    }


}
