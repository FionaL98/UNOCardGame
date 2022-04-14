package Cards;

public class Card {
    private final CardValue cardValue;
    private final CardColour cardColour;
    
    public Card(CardColour colour, CardValue value){
        this.cardColour = colour;
        this.cardValue = value;
    }

    public CardValue getCardValue(){
        return this.cardValue;
    }
    
    public CardColour getCardColour(){
        return this.cardColour;
    }
   
   @Override
   public String toString(){
       return this.getCardColour() + " - " + this.getCardValue();
   };
}
