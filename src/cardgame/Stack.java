package cardgame;

import java.util.*;

public class Stack {
    final static private int STACK_SIZE = 32;

    /**
     * The actual stack of cards.
     */
    Card[] cards;

    /**
     * The topmost card of this stack.
     */
    int top;
    public Stack() {
        this.generateCardsAndShuffle();
    }
    /**
     * Generates the stack of cards recursively.
     *
     * The generated stack consists of an ordered set of {@link #STACK_SIZE} cards,
     * i.e. every possible combination of {@link cardgame.CardColor} and {@link cardgame.CardValue}.
     *
     * TODO: implement me
     * DONE
     * @param color
     * @param value
     */
    private void generateCards(int color, int value) {
        // anchor
        if (top == Stack.STACK_SIZE){
            Set<Card> set = new HashSet<>(Arrays.asList(cards));
            set.toArray(cards);

            return;
        }


        if(color == 0 && value == 0){
            cards = new Card[Stack.STACK_SIZE];

        }
        if(value == 8){
            value = 0;
            color +=1;
        }
        if(color == 4){
            top = Stack.STACK_SIZE;
            cards[top-1] = new Card(CardColor.values()[color], CardValue.values()[value]);
        }

        top+=1;

        cards[top-1] = new Card(CardColor.values()[color], CardValue.values()[value]);

        value += 1;


        // ...

        // recursion step
        generateCards(color, value);
    }

    public void generateCardsAndShuffle() {
        generateCards(0, 0);
        shuffle();
    }



    /**
     * Shuffles the stack of cards.
     *
     * TODO: implement me. Helpful: {@link Collections} and {@link Arrays}
     * DONE
     */
    public void shuffle() {
        List<Card> list = Arrays.asList(cards);
        Collections.shuffle(list);
        list.toArray(cards);
    }

    /**
     * Get the amount of cards remaining in this stack.
     *
     * @return {@link #top}
     */
    public int size() {
        return top;
    }

    /**
     * Get the topmost card from this stack.
     *
     * TODO: implement me
     * @return
     */
    public Card reveal() {
        if(cards == null){
            this.generateCardsAndShuffle();
        }
        if(top == 0){
            System.out.printf("Stack ist leer");
            return null;
        }
        Card topcard = cards[top-1];
        top -=1;

        return topcard;
    }
}
