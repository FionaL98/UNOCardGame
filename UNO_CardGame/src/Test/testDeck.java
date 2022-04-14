package Test;
import org.junit.Test;

import Cards.Card;
import Cards.CardColour;
import Cards.CardValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;


public class testDeck {
  ArrayList<Card> cardDeck = new ArrayList<Card>();

  public ArrayList<Card> createDeck(){
    for (CardColour colour : CardColour.values()){
        for (CardValue value : CardValue.values()){
            Card card = new Card(colour, value);
            cardDeck.add(card);
        }
    }
    return cardDeck;
}

  @Test
  // Tests the creation of the card
  public void testCreateDeckGood() {
    createDeck();
    // expected
    int expectedResult = 60;
    int result = cardDeck.size();
    assertEquals(expectedResult, result);
}

@Test
// Tests the creation of the card
public void testCreateDeckBad() {
  createDeck();
  // expected
  int expectedResult = 50;
  int result = cardDeck.size();
  assertNotEquals(expectedResult, result);
}



}
