package cardgame;

import java.util.Arrays;

public class Hand {
    private final Card[] cards;

    private int count = 0;

    public Hand(int cardCount) {
        this.cards = new Card[cardCount];
    }

    /**
     * Swap a card from this hand with a card from another hand.
     * Both indices must point to valid indices, which is not checked.
     * TODO: implement me
     * DONE
     * @param otherHand
     * @param cardIndexOther
     * @param cardIndexThis
     */
    public void swapCard(Hand otherHand, int cardIndexOther, int cardIndexThis) {
        Card temp = this.cards[cardIndexThis];
        this.cards[cardIndexThis] = otherHand.cards[cardIndexOther];
        otherHand.cards[cardIndexOther] = temp;


    }

    /**
     * Swap the cards of two hands.
     * Both hands must hold the same amount of cards, which is not checked.
     *
     * TODO: implement me
     *DONE
     *  @param other
     */
    public void swap(Hand other) {
        for(int i = 0 ; i< this.cards.length; i++){
            this.swapCard(other, i, i);
        }

    }

    public void swapAll(Hand other){
        if(count == this.cards.length){
            count =0;
            return;
        }
        Card swapCard = other.cards[count];
        other.cards[count] = this.cards[count];
        this.cards[count] = swapCard;
        count +=1;
        swapAll(other);
    }

    @Override
    public String toString() {
        return Arrays.asList(cards).toString();
    }

    /**
     * Get a representation of the held cards as an array of strings.
     * @return
     */
    public String[] toStringArray() {
        String arr = Arrays.asList(cards).toString();
        return arr.substring(1, arr.length() - 1).split(",");
    }

    public void setCard(Card card, int index){
        cards[index] = card;
    }

    public Card getCard(int index){
        return cards[index];
    }

    public Card[] getCards() {
        return cards;
    }
}
