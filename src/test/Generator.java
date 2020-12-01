package test;

import cardgame.Card;
import cardgame.CardColor;
import cardgame.CardValue;
import schwimmen.Hand;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {
    static Random generator = new Random();

    /**
     * Generates a single random card from the schwimmen package.
     *
     * @return A random card.
     */
    static Card randomCard() {
        if (CardColor.values().length == 0 || CardValue.values().length == 0) {
            return null;
        }
        int cv = generator.nextInt(CardValue.values().length);
        int cc = generator.nextInt(CardColor.values().length);
        return new Card(CardColor.valueOf(CardColor.values()[cc].name()),
                CardValue.valueOf(CardValue.values()[cv].name()));
    }

    /**
     * Generates a hand of 3 randomly selected cards.
     * Note that already chosen cards are not removed from the 'stack'; it is possible therefore,
     * that a card is inserted twice.
     *
     * @return A random hand of not necessarily unique cards.
     */
    static Hand generateHand() {
        List<Card> cards = Stream.generate(() -> Generator.randomCard())
                .limit(3)
                .collect(Collectors.toList());

        return new Hand(cards.get(0), cards.get(1), cards.get(2));
    }
}
