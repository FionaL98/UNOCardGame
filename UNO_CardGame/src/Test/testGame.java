package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Game.ActionCardController;
import Game.Game;
import Player.Player;

public class testGame {

  @Test
  public void testPlayerRotationGood() {
    ArrayList<Player> playerlist = new ArrayList<>();
    playerlist.add(new Player("jim"));
    playerlist.add(new Player("mob"));
    playerlist.add(new Player("steve"));

    // boolean gameDirection = true;
    Game game = new Game(playerlist);

    int nextPlayerIndex = game.playerRotation();
    int expected = 1;
    int result = nextPlayerIndex;

    assertEquals(expected, result);
  }

  @Test
  public void testPlayerRotationBad() {
    ArrayList<Player> playerlist = new ArrayList<>();
    playerlist.add(new Player("jim"));
    playerlist.add(new Player("mob"));
    playerlist.add(new Player("steve"));

    // boolean gameDirection = true;
    Game game = new Game(playerlist);

    int nextPlayerIndex = game.playerRotation();
    int expected = 2;
    int result = nextPlayerIndex;

    assertNotEquals(expected, result);
  }

  @Test
  public void testGameOver(){
    Player player1 = new Player("Jim");
    boolean result = player1.getPlayerHand().getPlayerHandCards().isEmpty();

    assertTrue(result);
  }


  @Test
  public void testReverseAction(){
    ActionCardController gameController = new ActionCardController();
    boolean gameDirection = true;
    
    boolean result = gameController.reverseAction(gameDirection);

    assertFalse(result);
  }

}
