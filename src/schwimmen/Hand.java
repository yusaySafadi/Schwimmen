package schwimmen;

import cardgame.Card;
import cardgame.CardColor;
import cardgame.CardValue;

public class Hand {
    public static final int CARDS_PER_HAND = 3;
    public static final double THIRTY_AND_HALF = 30.5;

    private cardgame.Hand hand;

    public Hand(Card card1, Card card2, Card card3) {
        this.hand = new cardgame.Hand(CARDS_PER_HAND);
        this.hand.setCard(card1, 0);
        this.hand.setCard(card2, 1);
        this.hand.setCard(card3, 2);
    }

    /**
     * Swap a card from this hand with a card on another hand.
     *
     * Both indices must be in range [0, {@link #CARDS_PER_HAND}).
     *DONE
     * @param other
     * @param fromOtherHand is the index of the card from the other hand.
     * @param fromThisHand is the index of the card from this hand.
     */
    public void swapCard(Hand other, int fromOtherHand, int fromThisHand) {
        Card temp = this.hand.getCard(fromThisHand);
        this.hand.setCard(other.hand.getCard(fromOtherHand), fromThisHand);
        other.hand.setCard(temp, fromOtherHand);

    }

    /**
     * Swap all cards from two hands.
     * @param other
     * @see cardgame.Hand#swap
     */
    public void swapHand(Hand other) {
        this.hand.swap(other.hand);
    }

    public void swapAll(Hand other){
        this.hand.swapAll(other.hand);
    }

    public String[] toStringArray() {
        return new String[]{};
    }

    /**
     * TODO: implement me
     * DONE
     * @return
     */
    private boolean isThirtyAndHalf() {
        if(this.hand.getCards().length == 3){
            String firstCardValue = this.hand.getCard(0).getValue().name();
            String secondCardValue = this.hand.getCard(1).getValue().name();
            String thirdCardValue = this.hand.getCard(2).getValue().name();

            if( firstCardValue.equals(secondCardValue) &&
            firstCardValue.equals(thirdCardValue) ){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

    /**
     * Calculates the value of the hand, according to the rules of Schwimmen.
     *
     * If every card has the same {@link cardgame.CardValue}, the result is {@link #THIRTY_AND_HALF}.
     * Else, the result is calculated as the maximum of the sum of values for each color, where:
     * 7, 8, 9, 10 count as depicted;
     * Jack, Queen and King count ten;
     * Ace counts 11.
     * Therefore, the maximum achievable value is 31, the minimum 8 (as three 7 would be 30.5).
     *
     * TODO: implement me
     * @return the nominal value of this hand.
     *
     * DONEE
     */
    public double value() {
        if (isThirtyAndHalf()) {
            return THIRTY_AND_HALF;
        }

        double maxSumSpades = 0.0;
        double maxSumDiamonds = 0.0;
        double maxSumHearts = 0.0;
        double maxSumClover = 0.0;

        for(Card card : this.hand.getCards()){
            if(card.getColor().name().equals(CardColor.SPADES.name())){
                maxSumSpades += card.getValue().getValue();
            }else if (card.getColor().name().equals(CardColor.DIAMONDS.name())){
                maxSumDiamonds += card.getValue().getValue();
            }else if(card.getColor().name().equals(CardColor.HEARTS.name())){
                maxSumHearts += card.getValue().getValue();
            } else if(card.getColor().name().equals(CardColor.CLOVER.name())){
                maxSumClover += card.getValue().getValue();
            }

        }

        double[] arr = {maxSumClover,maxSumDiamonds,maxSumHearts,maxSumSpades};
        double max = 0.0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i]> max){
                max = arr[i];
            }
        }
        return max;

    }

    @Override
    public String toString() {
        return hand != null? hand.toString() + " (" + value() + ")" : "";
    }

    public cardgame.Hand getHand() {
        return hand;
    }
}
