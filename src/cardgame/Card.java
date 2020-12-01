package cardgame;

public class Card {
    private final CardValue value;
    private final CardColor color;

    public Card(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() { return this.value.name() + " of " + this.color.name();
    }

    @Override
    public boolean equals(Object other) {
        Card otherCard = (Card) other;
        return value == otherCard.value && color == otherCard.color;
    }

    public CardValue getValue() {
        return value;
    }

    public CardColor getColor() {
        return color;
    }
}
