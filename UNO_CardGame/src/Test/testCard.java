package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Cards.Card;
import Cards.CardColour;
import Cards.CardValue;
import Decks.Deck;
import Decks.DrawPile;
import Game.Game;
import Player.Player;
import Player.PlayerHand;

public class testCard {
  
  @Test
  public void testCreatingCardGood(){
    Card card1 = new Card(CardColour.BLUE, CardValue.FIVE);

    // testing the colour of the newly created card
    CardColour expectedCardColour = CardColour.BLUE;
    CardColour resultCardColour = card1.getCardColour();
    assertEquals(expectedCardColour, resultCardColour);

    // testing the values of the newly created card
    CardValue expectedCardValue = CardValue.FIVE;
    CardValue resultCardValue = card1.getCardValue();
    assertEquals(expectedCardValue, resultCardValue);
  }

  @Test
  public void testCreatingCardBad(){
    Card card1 = new Card(CardColour.BLUE, CardValue.FIVE);

    // testing the colour of the newly created card
    CardColour expectedCardColour = CardColour.RED;
    CardColour resultCardColour = card1.getCardColour();
    assertNotEquals(expectedCardColour, resultCardColour);

    // testing the values of the newly created card
    CardValue expectedCardValue = CardValue.FOUR;
    CardValue resultCardValue = card1.getCardValue();
    assertNotEquals(expectedCardValue, resultCardValue);
  }

  @Test
  public void testAddingCardToPlayerHandsGood(){
    ArrayList<Card> playerHandCards = new ArrayList<Card>();
    Card card1 = new Card(CardColour.BLUE, CardValue.FIVE);
    playerHandCards.add(card1);

    String result = playerHandCards.get(0).toString();
    String expectedResult = "BLUE - FIVE";

    assertEquals(expectedResult, result);
  }

  @Test
  public void testAddingCardToPlayerHandsBad(){
    ArrayList<Card> playerHandCards = new ArrayList<Card>();
    Card card1 = new Card(CardColour.BLUE, CardValue.FIVE);
    playerHandCards.add(card1);

    String result = playerHandCards.get(0).toString();
    String expectedResult = "RED - SIX";

    assertNotEquals(expectedResult, result);
  }

  @Test
  public void testCanPlayCard(){
    // Creating card
    Card card1 = new Card(CardColour.BLUE, CardValue.FIVE);
    Card topCard = new Card(CardColour.BLUE, CardValue.FOUR);

    // instantiate playerhands
    PlayerHand playerhands = new PlayerHand();

    // add top card
    playerhands.addCard(topCard);
    
    // check if playable
    boolean result = playerhands.canPlayACard(card1);
    assertTrue(result);
  }


  @Test
  public void testDrawCardGood(){
    Deck deck = new Deck();
    deck.createDeck();
    DrawPile drawpile = new DrawPile(deck.getCardDeck());
    DrawPile drawPile2 = new DrawPile(deck.getCardDeck());

    Card drawnCard = drawpile.drawCard();

    Card result = drawnCard;
    Card expected = drawPile2.drawCard();

    assertEquals(expected, result);
  }

  @Test
  public void testDrawCardBad(){
    Deck deck = new Deck();
    deck.createDeck();
    DrawPile drawpile = new DrawPile(deck.getCardDeck());
    DrawPile drawPile2 = new DrawPile(deck.getCardDeck());

    Card drawnCard = drawpile.drawCard();

    Card result = drawnCard;
    drawPile2.drawCard();
    Card expectedBad = drawPile2.drawCard();

    assertNotEquals(expectedBad, result);
  }

  @Test
  public void testGetPlayerCardGood(){
    ArrayList<Player> playerlist = new ArrayList<>();
    Player player1 = new Player("jimmy");
    Player player2 = new Player("mike");
    playerlist.add(player1);
    playerlist.add(player2);
    Game game = new Game(playerlist);

    Card expected = player1.getPlayerHand().getPlayerHandCards().get(1);
    Card result = game.getPlayerCard(player1, 1); 

    assertEquals(expected, result);
  }

  @Test
  public void testGetPlayerCardBad(){
    ArrayList<Player> playerlist = new ArrayList<>();
    Player player1 = new Player("jimmy");
    Player player2 = new Player("mike");
    playerlist.add(player1);
    playerlist.add(player2);
    Game game = new Game(playerlist);

    Card expected = player1.getPlayerHand().getPlayerHandCards().get(2);
    Card result = game.getPlayerCard(player1, 1); 

    assertNotEquals(expected, result);
  }

  @Test
  public void testValidCardPlayed(){
    ArrayList<Player> playerlist = new ArrayList<>();
    Player player1 = new Player("jimmy");
    Player player2 = new Player("mike");
    playerlist.add(player1);
    playerlist.add(player2);
    Game game = new Game(playerlist);
    game.start(game);

    // Creating card
    Card cardPlayed = game.getDiscardPile().getTopCard();
    boolean result = game.validCardPlayed(cardPlayed);

    assertTrue(result);
  }

  // Test cases for manual tests
  // testSkipAction()
  // 1. Begin the game
  // 2. Continue playing the game until you are presented with the option to play a card that allows you to skip the next player's turn
  // 3. Select that option
  // 4. You will notice that once you selected the option to play a SKIP card, the terminal will prompt a message indicating that you skipped the player ahead of you and it went to the next player. It will also display the player's turn.
  // 5. For example, if the order is A, B, C and D and player A had played the skip card, it will go to player C and display the message : ** SPECIAL ACTION: Player b's turn was skipped

  // testDrawFourAction()
  // 1. Begin the game
  // 2. Continue playing the game until you are presented with the option to play a card that allows you to force the next player to pick up 4 cards
  // 3. Select that option
  // 4. You will notice that once you selected the option to play a DRAW4 card, the next player will have an additional 4 cards to their hand.
  // 5. For example, if the order is A, B, C and D and player A had played the draw4 card, then player B who had previously had 8 cards, will have a prompt that would display the message: 
  //***Player b's turn***
  //Number of Cards in your hand: 12

  // testDrawTwoAction()
  // 1. Begin the game
  // 2. Continue playing the game until you are presented with the option to play a card that allows you to force the next player to pick up 2 cards
  // 3. Select that option
  // 4. You will notice that once you selected the option to play a DRAW2 card, the next player will have an additional 2 cards to their hand.
  // 5. For example, if the order is A, B, C and D and player A had played the draw2 card, then player B who had previously had 8 cards, will have a prompt that would display the message: 
  //***Player b's turn***
  //Number of Cards in your hand: 10

  // testWildColourAction()
  // 1. Begin the game
  // 2. Continue playing the game until you are presented with the option to play a card that allows you to change the color of the topCardColour
  // 3. Select that option
  // 4. You will notice that once you selected the option to play a WILDCARD card, you will be prompted with the following message: ** SPECIAL ACTION: Choose a colour to change to: 
         //BLUE, RED, GREEN, YELLOW: 
  // 5. Type in the colour that you wish to change to
  // 6. Afterwards, you will notice that the Current Top card: will change to the colour that you chose.
  // 7. For example:  ** SPECIAL ACTION: Choose a colour to change to: 
                     //BLUE, RED, GREEN, YELLOW: red
                     //Current Top Card: RED - WILDCOLOUR




}
