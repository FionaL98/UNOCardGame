package Decks;

import java.util.Stack;

import Cards.Card;
import Cards.CardColour;

public class DiscardPile {
    Stack<Card> discardPile = new Stack<>();
    Card topCard;

    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Stack<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public DiscardPile(Card card){
        this.topCard = card;
        discardPile.push(card);
    }

    public Card showTopCard() {
        return discardPile.peek();
    }

    public Card getTopCard(){
        return this.topCard;
    }

    public void newTopCard(Card card){
        this.discardPile.push(card);
        this.topCard = card;
    }

    public void wildcolourChangeCardColour(CardColour colour){
        this.topCard = new Card(colour, this.topCard.getCardValue());
    }
}
