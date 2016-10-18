package problem054;

/**
 * Created by kiran on 1/25/16.
 */
public class Card {

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    private int value;
    private char suit;

    public Card(char value, char suit) {
        this.value = parseValue(value);
        this.suit = suit;
    }

    private int parseValue(char value) {
        switch (value) {
            case 'T':
                return 10;
            case 'J':
                return JACK;
            case 'Q':
                return QUEEN;
            case 'K':
                return KING;
            case 'A':
                return ACE;
            default:
                return value - '0';
        }
    }

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
