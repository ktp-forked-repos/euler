package problem054;

/**
 * Created by kiran on 1/25/16.
 */
public class PokerHand {

    public static final int HIGH_CARD       = 0;
    public static final int ONE_PAIR        = 1;
    public static final int TWO_PAIRS       = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT        = 4;
    public static final int FLUSH           = 5;
    public static final int FULL_HOUSE      = 6;
    public static final int FOUR_OF_A_KIND  = 7;
    public static final int STRAIGHT_FLUSH  = 8;
    public static final int ROYAL_FLUSH     = 9;

    private Card[] cards;
    public int handType;
    public int handRank;

    public PokerHand(Card[] cards) {
        this.cards = cards;
        sort();
        handType = determineHandType();
    }

    private void sort() {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < 4; i++) {
                if (cards[i].getValue() > cards[i + 1].getValue()) {
                    Card temp = cards[i];
                    cards[i] = cards[i + 1];
                    cards[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private int determineHandType() {
        if (isFlush() && isStraight() && cards[4].getValue() == Card.ACE) return ROYAL_FLUSH;
        if (isFlush() && isStraight()) return STRAIGHT_FLUSH;
        if (isFourOfAKind())           return FOUR_OF_A_KIND;
        if (isFullHouse())             return FULL_HOUSE;
        if (isFlush())                 return FLUSH;
        if (isStraight())              return STRAIGHT;
        if (isThreeOfAKind())          return THREE_OF_A_KIND;
        if (isTwoPairs())              return TWO_PAIRS;
        if (isOnePair())               return ONE_PAIR;
        return HIGH_CARD;
    }

    public void print() {
        for (Card card : cards) {
            System.out.print(card.getValue() + "" + card.getSuit() + " ");
        }
        System.out.println();
    }


    private boolean isFlush() {
        char suit = cards[0].getSuit();
        if (cards[1].getSuit() == suit &&
            cards[2].getSuit() == suit &&
            cards[3].getSuit() == suit &&
            cards[4].getSuit() == suit) {
            handRank = cards[4].getValue();
            return true;
        }

        return false;
    }

    private boolean isStraight() {
        if (cards[1].getValue() == cards[0].getValue() + 1 &&
            cards[2].getValue() == cards[0].getValue() + 2 &&
            cards[3].getValue() == cards[0].getValue() + 3 &&
            cards[4].getValue() == cards[0].getValue() + 4) {
            handRank = cards[4].getValue();
            return true;
        }

        return false;
    }

    private boolean isFourOfAKind() {
        if (cards[0].getValue() == cards[1].getValue() &&
            cards[0].getValue() == cards[2].getValue() &&
            cards[0].getValue() == cards[3].getValue()) {
            handRank = cards[0].getValue();
            return true;
        }

        if (cards[1].getValue() == cards[2].getValue() &&
            cards[1].getValue() == cards[3].getValue() &&
            cards[1].getValue() == cards[4].getValue()) {
            handRank = cards[1].getValue();
            return true;
        }

        return false;
    }

    private boolean isFullHouse() {
        if (cards[1].getValue() == cards[0].getValue() &&
            cards[2].getValue() == cards[3].getValue() &&
            cards[3].getValue() == cards[4].getValue()) {
            handRank = cards[2].getValue();
            return true;
        }

        if (cards[3].getValue() == cards[4].getValue() &&
            cards[0].getValue() == cards[1].getValue() &&
            cards[1].getValue() == cards[2].getValue()) {
            handRank = cards[0].getValue();
            return true;
        }

        return false;
    }

    private boolean isThreeOfAKind() {
        if (cards[0].getValue() == cards[1].getValue() &&
            cards[0].getValue() == cards[2].getValue()) {
            handRank = cards[0].getValue();
            return true;
        }

        if (cards[1].getValue() == cards[2].getValue() &&
            cards[1].getValue() == cards[3].getValue()) {
            handRank = cards[1].getValue();
            return true;
        }

        if (cards[2].getValue() == cards[3].getValue() &&
            cards[2].getValue() == cards[4].getValue()) {
            handRank = cards[2].getValue();
            return true;
        }

        return false;
    }

    private boolean isTwoPairs() {
        if (cards[0].getValue() == cards[1].getValue() &&
            cards[2].getValue() == cards[3].getValue()) {
            handRank = cards[0].getValue() > cards[2].getValue() ? cards[0].getValue() : cards[2].getValue();
            return true;
        }

        if (cards[0].getValue() == cards[1].getValue() &&
            cards[3].getValue() == cards[4].getValue()) {
            handRank = cards[0].getValue() > cards[3].getValue() ? cards[0].getValue() : cards[3].getValue();
            return true;
        }

        if (cards[1].getValue() == cards[2].getValue() &&
            cards[3].getValue() == cards[4].getValue()) {
            handRank = cards[1].getValue() > cards[3].getValue() ? cards[1].getValue() : cards[3].getValue();
            return true;
        }

        return false;
    }

    private boolean isOnePair() {
        if (cards[0].getValue() == cards[1].getValue()) {
            handRank = cards[0].getValue();
            return true;
        }

        if (cards[1].getValue() == cards[2].getValue()) {
            handRank = cards[1].getValue();
            return true;
        }

        if (cards[2].getValue() == cards[3].getValue()) {
            handRank = cards[2].getValue();
            return true;
        }

        if (cards[3].getValue() == cards[4].getValue()) {
            handRank = cards[3].getValue();
            return true;
        }

        return false;
    }

    public Card getCard(int index) {
        return cards[index];
    }

    public boolean beats(PokerHand otherHand) {
        if (handType > otherHand.handType) {
            return true;
        } else if (otherHand.handType > handType) {
            return false;
        }

        if (handRank > otherHand.handRank) {
            return true;
        } else if (otherHand.handRank > handRank) {
            return false;
        }

        for (int i = 4; i > 0; i--) {
            if (cards[i].getValue() > otherHand.getCard(i).getValue()) {
                return true;
            } else if (otherHand.getCard(i).getValue() > cards[i].getValue()) {
                return false;
            }
        }

        System.out.print("ERROR: NO CLEAR WINNER");
        return false;
    }
}