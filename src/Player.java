/**
 * Class which represents a player for the game of BlackJack. This class will be used to model
 * human and computer players. This class contains methods for displaying hands, adding cards
 * to a hand and detecting what hand type the player has.
 * A player is allowed up to eleven cards. Trying to add more than eleven is not allowed.
 *
 * @author Caleb Register
 * @author Sasha Donaldson
 * @version 10/23/2024
 */
public class Player {
    /** Current number of cards in a player's hand */
    private int cardsInHand;
    /** A player hand */
    private Card[] hand;
    /** Max cards a player can have */
    private static int MAX_CARDS = 11;  // removed "final" and set to 11
    /** The player's name */
    private String name;

    /**
     * Create a player with a name.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Creates a player with a default name of "Player" by calling other constructor.
     */
    public Player() {
        this("Player");
    }

    /**
     * Set the player's name.
     * @param name The new player name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the player's name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the number of cards in the player's hand.
     * @return
     */
    public int cardCount() {
        return hand.length;
    }

    /**
     * Add a card to a player's hand.
     * @param card
     * @return
     */
    public boolean addCard(Card card) {
        ;
    }

    /**
     * Set a card in the players hand.
     * @param index The index of the card set.
     * @param card The new card.
     */
    public void setCard(int index, Card card) {
        hand[index] = card;
    }

    /**
     * Get a card in the player's hand.
     * @param index
     * @return
     */
    public Card getCard(int index) {
        ;
    }

    /**
     * Clear the cards in the player's hand.
     */
    public void clearCards() {
        hand = new Card[MAX_CARDS];
    }

    /**
     * Determine if the player's hand has reached the card limit.
     * @return boolean indicating of a player's hand greater than or equal to the card limit.
     */
    public boolean isFull() {
        return hand.length >= MAX_CARDS;
    }

    /**
     * Create a String representing the current state of the object.
     * @return String expressing the hand.
     */
    @Override                  // is this needed?
    public String toString() {
        String handExpression = this.name + "'s Hand:\n\t";
        int count = 0;
        if (cardsInHand > 0) {
            for (Card card : hand) {
                if (count == 1) {
                    handExpression = handExpression + "\t|\t";
                }
                handExpression = handExpression + card;
                count = 1;
            }
        } else {
            handExpression = handExpression + "No cards";
        }
        return handExpression;
    }

    /**
     * Add up the value of each card in the player's hand.
     * @return
     */
    public int handValue() {
        int total = 0;
        for (Card card : hand) {
            total += card.getName().value();  // Changed to ".getName" from ".name"
        }
        return total;
    }

    /**
     * Makes all the cards in the player's hand be face up.
     */
    public void turnCardsUp() {
        ;
    }

    /**
     * Return the hand type of the player.
     * @return
     */
    public HandType getHandType() {
        HandType handType = null;
        if (isBust()) {
            handType = HandType.BUST;
        }
        if (handValue() > 21) {
            handType = HandType.TOTAL;
        }
        else {
            if (cardsInHand == 5) {
                handType = HandType.TRICK_5;
            }
            if (cardsInHand <= 4) {
                handType = HandType.FOUR_OR_LESS;
            }
            if (cardsInHand == 2) {
                handType = HandType.BJACK;
            }
            if (cardsInHand >= 6) {
                handType = HandType.SIX_OR_MORE;
            }
        }
        return handType;
    }

    /**
     * Does this hand total to 21 in less than or equal to value number of cards?
     * @param value
     * @return
     */
    private boolean isBlackJack(int value) {
        return handValue() == 21;
    }

    /**
     * It this player's hand bust, that is a value of over 21.
     * @return boolean indicating if a player's hand is greater than 21.
     */
    private boolean isBust() {
        return handValue() > 21;
    }

    /**
     * Computer this hand with the otherPlayer.
     * @param otherPlayer
     * @return
     */
    public int compareTo(Player otherPlayer) {
        int scoreDifference = 0;
        HandType playerHandType = getHandType();
        HandType otherHandType = otherPlayer.getHandType();
        if (playerHandType == HandType.TOTAL && otherHandType == HandType.TOTAL) {
            scoreDifference = handValue() - otherPlayer.handValue();
        }
        else {
            scoreDifference = playerHandType.ordinal() - otherHandType.ordinal();
        }
        return scoreDifference;
    }
}
