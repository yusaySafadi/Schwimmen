package cardgame;

/**
 * TODO: implement me. Remember to add a custom value.
 * BEARBEITET EVT TO STRING
 */
public enum CardValue  {
    SEVEN(7.0), EIGHT(8.0),NINE(9.0), TEN(10.0), JACK(10.0),QUEEN(10.0),KING(10.0),ACE(11.0);

    private double cardValue;

    CardValue(double value){
        cardValue = value;
    }

    public double getValue(){
        return this.cardValue;
    }




}
