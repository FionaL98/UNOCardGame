import Game.Game;
import Game.GameMessages;
import Util.Signup;

public class App {
    public static void main(String[] args) throws Exception {
        GameMessages gameMessages = new GameMessages();
        Signup signup = new Signup();

        System.out.println(gameMessages.getWelcomeMessage() + gameMessages.getGameRules());
        signup.signUpSession();

        System.out.println("\n\nNow creating new Game...\n");
        Game game = new Game(signup.playerlist);

        game.start(game);
        System.out.println("\n====================================");
        game.beginPlayerTurns();
    }
}
