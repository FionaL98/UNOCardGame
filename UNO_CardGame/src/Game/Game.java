package Game;
import java.util.ArrayList;

import Cards.Card;
import Cards.CardColour;
import Cards.CardValue;
import Decks.Deck;
import Decks.DiscardPile;
import Decks.DrawPile;
import Player.Player;
import Player.PlayerTurn;
import Util.UserInput;

public class Game {
    Deck cardDeck;

    UserInput userInput = new UserInput();
    GameMessages gameMessages = new GameMessages();
    ActionCardController gameController = new ActionCardController();

    DrawPile drawPile;
    DiscardPile discardPile;

    ArrayList<Player> playerlist = new ArrayList<>();
    PlayerTurn playerTurn;
    int currentPlayerIndex;

    CardValue topCardValue;
    CardColour topCardColour;
    boolean gameDirection;

    public Game(ArrayList<Player> playerlist){
        cardDeck = new Deck();
        cardDeck.createDeck();
        cardDeck.shuffleDeck();

        this.playerlist = playerlist;
        this.drawPile = new DrawPile(cardDeck.getCardDeck());
        cardDeck.distributePlayerCards(drawPile, playerlist);

        this.playerTurn = new PlayerTurn();
        this.playerTurn.setPlayers(playerlist);
        playerTurn.randomizePlayerOrder();
        playerTurn.showPlayerOrder();

        gameDirection = true;
        currentPlayerIndex = 0;
    }

    public void start(Game game){
        Card firstCard = drawPile.drawCard();
        topCardColour = firstCard.getCardColour();
        topCardValue = firstCard.getCardValue();

        CardValue[] cardValues = CardValue.values();
        for (int i=10; i<cardValues.length; i++){
            if (firstCard.getCardValue() == cardValues[i]){
                start(game);
            }
        }

        this.discardPile = new DiscardPile(firstCard);
        gameMessages.displayTopCardMessage(topCardColour, topCardValue);
    }

    public Card getPlayerCard(Player player, int index){
        return player.getPlayerHand().getPlayerHandCards().get(index);
    }

    public Card drawCard(){
        Card drawnCard = drawPile.drawCard();
        return drawnCard;
    }

    public void playCard(Player player, Card card){
        if(!validCardPlayed(card)){
            if(card.getCardValue() == CardValue.WILDCOLOUR){
                topCardColour = card.getCardColour();
                topCardValue = card.getCardValue();
            }
        }

        player.getPlayerHand().getPlayerHandCards().remove(card);
        topCardColour = card.getCardColour();
        topCardValue = card.getCardValue();
        discardPile.newTopCard(card);

        if (player.getPlayerHand().getPlayerHandCards().size() == 0){
            gameMessages.playerHasEmptyHandMessage(player);
        }

        if (card.getCardValue() == CardValue.WILDCOLOUR){
            topCardColour = gameController.wildColourAction(topCardColour, discardPile);
        }

        if(card.getCardValue() == CardValue.DRAW2){
            gameController.drawTwoAction(gameDirection, currentPlayerIndex, playerlist, drawPile);
        }

        if (card.getCardValue() == CardValue.DRAW4){
            gameController.drawFourAction(gameDirection, currentPlayerIndex, playerlist, drawPile);
        }

        if (card.getCardValue() == CardValue.SKIP){
            gameController.skipAction(gameDirection, currentPlayerIndex, playerlist);
            this.currentPlayerIndex = playerRotation();
        }

        if (card.getCardValue() == CardValue.REVERSE){
            gameDirection = gameController.reverseAction(gameDirection);
        }
        
        this.currentPlayerIndex = playerRotation();
        gameMessages.displayTopCardMessage(topCardColour, topCardValue);
        checkIfDrawPileIsEmpty();
    }

    public void beginPlayerTurns(){
        while (!isGameOver()){
            Player currentPlayer = playerlist.get(getCurrentPlayer());
            GameMessages.declareCurrentPlayerMessage(currentPlayer);

            if (playerlist.get(getCurrentPlayer()).getPlayerHand().canPlayACard(getDiscardPile().getTopCard())){
                gameMessages.currentPlayerHandSize(currentPlayer);
                gameMessages.currentPlayerPlayableCardsMessage(currentPlayer, getDiscardPile().getTopCard());
                gameMessages.displayPlayerPosition();
                    userInput.setNumInputForPosition();
                    int numInput = userInput.getNumInputForPosition();
                    if(numInput != -1){
                        Card selectedCard = getPlayerCard(playerlist.get(getCurrentPlayer()), numInput);
                        if (validCardPlayed(selectedCard)){
                            playCard(playerlist.get(getCurrentPlayer()), selectedCard);
                        } else {
                            gameMessages.displayCannotPlayCard();
                            gameMessages.displayPlayerPosition();
                            userInput.setNumInputForPosition();
                        }
                    }else {
                        quitGame();
                    }
            } else {
                gameMessages.currentPlayerHandSize(currentPlayer);
                gameMessages.displayNoPlayableCards();
                    userInput.setTypeDraw();
                    String playerDraw = userInput.getTypeDraw().toUpperCase();
                    if (playerDraw.equals("DRAW")){
                        playerlist.get(getCurrentPlayer()).getPlayerHand().addCard(drawCard());
                        gameMessages.playerDrewACard(playerlist.get(getCurrentPlayer()));
                        this.currentPlayerIndex = playerRotation();
                    } else if(playerDraw.equals("-1")) {
                        quitGame();
                    } else {
                        gameMessages.displayInValidInputForDraw();
                        gameMessages.displayNoPlayableCards();
                        userInput.setTypeDraw();
                    }
            }
        }
    }

    public int playerRotation(){
        if (gameDirection == true){
            if (currentPlayerIndex == playerlist.size() - 1){
                currentPlayerIndex = 0;
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % playerlist.size();
            }
        } else {
            if (currentPlayerIndex == 0){
                currentPlayerIndex = playerlist.size() - 1;
            } else {
                currentPlayerIndex = (currentPlayerIndex - 1) % playerlist.size();
            }
        }
        return currentPlayerIndex;
    }

    public void quitGame(){
        gameMessages.quitGameMessage();
        System.exit(1);
    }

    protected void checkIfDrawPileIsEmpty(){
        if(drawPile.getSize() == 0){
            System.out.println("Out of cards! Game is ending");
            quitGame();
        }
    }

    public boolean validCardPlayed(Card card){
        if (discardPile.getTopCard().getCardColour() == card.getCardColour()){
            return true;
        } else if (discardPile.getTopCard().getCardValue() == card.getCardValue()){
            return true;
        }
        return false;
    }

    public boolean isGameOver(){
        for (Player player : playerlist){
            if (player.getPlayerHand().getPlayerHandCards().isEmpty()){
                return true;
            }
        }
        return false;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(DiscardPile discardPile) {
        this.discardPile = discardPile;
    }

    public void setTopCardValue(){
        topCardValue = discardPile.getTopCard().getCardValue();
    }

    public void setTopCardColour(){
        topCardColour = discardPile.getTopCard().getCardColour();
    }

    public DrawPile getDrawPile() {
        return drawPile;
    }

    public void setDrawPile(DrawPile drawPile) {
        this.drawPile = drawPile;
    }

    public int getCurrentPlayer(){
        return this.currentPlayerIndex;
    }
}
