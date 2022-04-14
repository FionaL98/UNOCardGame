package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Player.Player;

public class testPlayer {

  @Test
  // Tests the creation of the card
  public void testCreatePlayerGood() {
    // Given
    Player player1 = new Player("john");
    String expected = player1.getName();
    String result = "john";

    assertEquals(expected, result);
  }

  @Test
  public void testCreatePlayerBad(){
    Player player1 = new Player("john");
    String expected = player1.getName();
    String result = "mark";

    assertNotEquals(expected, result);
  }



}
