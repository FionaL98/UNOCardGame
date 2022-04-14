package Decks;

import java.util.ArrayList;
import java.util.Stack;

import Cards.Card;

public class DrawPile {
    private final Stack<Card> drawPile = new Stack<>();

    public DrawPile(ArrayList<Card> shuffledDeck){
        drawPile.addAll(shuffledDeck);
    }

    public Card drawCard(){
        Card card = drawPile.pop();
        return card;
    }

    public int getSize(){
        return this.drawPile.size();
    }

    public Stack<Card> getDrawPile(){
        return drawPile;
    }
}
