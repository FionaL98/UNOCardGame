package Decks;
import java.util.ArrayList;
import java.util.Random;

import Cards.Card;
import Cards.CardColour;
import Cards.CardValue;
import Player.Player;

public class Deck {
    private ArrayList<Card> cardDeck = new ArrayList<Card>();

    public ArrayList<Card> createDeck(){
        for (CardColour colour : CardColour.values()){
            for (CardValue value : CardValue.values()){
                Card card = new Card(colour, value);
                cardDeck.add(card);
            }
        }
        return cardDeck;
    }

    public void shuffleDeck(){
        Random r = new Random();
        for (int i=cardDeck.size() - 1; i > 0; i--){
            int pick = r.nextInt(i);
            Card randomCard = cardDeck.get(pick);
            Card lastCard = cardDeck.get(i);
            cardDeck.set(i, randomCard);
            cardDeck.set(pick, lastCard);
        }
    }

    public void distributePlayerCards(DrawPile drawPile, ArrayList<Player> players){
        for (int i=0; i<8; i++){
            for (Player player : players){
                player.getPlayerHand().addCard(drawPile.drawCard());
            }
        }
    }

    public ArrayList<Card> getCardDeck(){
        return this.cardDeck;
    }

    public String showCardDeck(){
        String string = "";
        for (Card card : cardDeck){
            string += card.toString() + "\n";
        }

        return string;
    }

    
}
