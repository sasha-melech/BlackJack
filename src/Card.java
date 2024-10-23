/**
 * Class which represents cards.
 *
 * @author Caleb Register
 * @author Sasha Donaldson
 * @version 10/23/2024
 */
public class Card {
    /** The cards face name and value */
    private Face name;
    /** The suit of the card */
    private Suit suit;
    /** True if this card is face down */
    private boolean faceDown;

    /**
     * Constructs a new card.
     * @param name The name of the card which is an instance of the Face enum.
     * @param suit The suit of the card which is an instance of the Suit enum.
     */
    public Card(Face name, Suit suit) {
        this.name = name;
        this.suit = suit;
    }

    /**
     * Constructs a new card.
     * @param name The name of the card which is an instance of the Face enum.
     * @param suit The suit of the card which is an instance of the Suit enum.
     * @param faceDown True if this card is to be shown face down.
     */
    public Card(Face name, Suit suit, boolean faceDown) {
        this.name = name;
        this.suit = suit;
        this.faceDown = faceDown;
    }

    /**
     * Get the name of the card for example, Ace, Ten, Jack, Queen, or King.
     * @return The face name.
     */
    public Face getName() {
        return name;
    }

    /**
     * Get the suit of the card. i.e., Spade, Heart, Club, or Diamond.
     * @return The suit name.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Get the rank number of the card. The rank is a number between
     * 1 and 13 where 1 is a deuce and 13 is an ace.
     * @return The rank of the card.
     */
    public int rank() {
        return name.rank();
    }

    /**
     * Get the card's value, that is the number between 2 to 11. Ace has the value 11,
     * all royals (picture card) have the value 10, all others cards are worth face value.
     * @return The value of a card.
     */
    public int value() {
        return name.value();
    }

    /**
     * Set the card to be shown face up.
     */
    public void setFaceUp() {
        faceDown = false;
    }

    /**
     * Set the card to be shown face down.
     */
    public void setFaceDown() {
        faceDown = true;
    }

    /**
     * Is this card face down.
     * @return true if the card is face down, false otherwise.
     */
    public boolean isFaceDown() {
        return faceDown;
    }

    /**
     * Comparing two cards using the ranks of each card. If <i>this</i> card's rank is higher
     * than the <i>other</i> card's rank then return a positive value. If <i>this</i> card's
     * rank is less than the <i>other</i> card's rank return a negative value.
     * If the cards' ranks are equal, return zero.
     * @param other the card to be compared
     * @return a negative integer, zero, or a positive integer if this card is less than,
     * equal to, or greater than the specified card.
     */
    public int compareTo(Card other) {
        int hasHigherRank; // Create temp variable to reduce number of return statements
        if (this.rank() > other.rank()) {    // NOT SURE IF THIS WORKS CORRECTLY
            hasHigherRank = 1;
        } else if (this.rank() == other.rank()) {
            hasHigherRank = 0;
        } else {
            hasHigherRank = -1;
        }
        return hasHigherRank;
    }

    /**
     * If the card is face up, then display the card's value and suit.
     * If the card is face down return six asterisks.
     * @return the card's face value and suit or six asterisks
     */
    public String toString() {
        String card;  // Creating temp variable to reduce number of return statements.
        if (faceDown) {
            card = "******";
        } else {
            card = String.format("%5s of %s", name.toString(), suit.toString());
        }
        return card;
    }
}

// I don't know why this exists, commented out for now and rewritten above.

//public record Card(Face name, Suit suit, boolean faceDown) {
//
//    @Override
//    public String toString() {
//        return String.format("%5s of %s", name.toString(), suit.toString());
//    }
//}
//

/**
 * This enumeration represents the four suits in playing cards: Spade, Heart, Club, and Diamond.
 */
enum Suit {
    /** Representation of Spades */
    SPADE("Spades"),
    /** Representation of Hearts */
    HEART("Hearts"),
    /** Representation of Clubs */
    CLUB("Clubs"),
    /** Representation of Diamonds */
    DIAMOND("Diamonds");

    /** The suit name */
    private String name;  //made change to 'private' rather than 'final' to match documentation

    /** Constructs a suit. */
    private Suit(String name) {
        this.name = name;
    }

    /**
     * Get the name of the suit.
     * @return The name of the suit.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the state of this enumeration.
     * @return A string containing the suit name.
     */
    @Override                   // is this needed?
    public String toString() {
        return name;
    }
}

/**
 * This enumeration represents the face of a card from Deuce(2) through King(10).
 * Each card has a value where deuce is 2, three is 3 and so on, up to 10.
 * All royals (picture cards) are worth 10 points each.
 * Each card also has a rank. The rank represents the respective ordering of these cards
 * with respect to their power. An ace is the highest ranking, then king, queen, jack,
 * followed by the number cards.
 */
enum Face {
    /** Face value of 2 */
    DEUCE("Deuce", 2),
    /** Face value of 3 */
    THREE("Three", 3),
    /** Face value of 4 */
    FOUR("Four", 4),
    /** Face value of 5 */
    FIVE("Five", 5),
    /** Face value of 6 */
    SIX("Six", 6),
    /** Face value of 7 */
    SEVEN("Seven", 7),
    /** Face value of 8 */
    EIGHT("Eight", 8),
    /** Face value of 9 */
    NINE("Nine", 9),
    /** Face value of 10 */
    TEN("Ten", 10),
    /** Royal value of Jack */
    JACK("Jack", 10),
    /** Royal value of Queen */
    QUEEN("Queen", 10),
    /** Royal value of King */
    KING("King", 10),
    /** Face value of Ace */
    ACE("Ace", 11);

    /** The face of this card */
    private String face;
    /** The value of this card */
    private int value;
    /** The rank of this card */
    private int rank;

    /**
     * Construct a face enumeration. Ranks in poker are from highest to lowest:
     * Ace, King, Queen, Jack, 10, 9, 8, 7, 6, 5, 4, 3, 2. In blackjack Ace is worth 11,
     * unless it causes the player to bust, then it counts as 1.
     * @param name The name of the card as displayed.
     * @param value The value of the card.
     */
    private Face(String name, int value) {
        face = name;
        this.value = value;
        setRank(); // Call helper function to set rank
    }

    /**
     * The value of this card.
     * @return The card's value.
     */
    public int value() {
        return value;
    }

    /**
     * The rank of this card.
     * @return The card's rank.
     */
    public int rank() {
        return rank;
    }

    /**
     * Sets the rank of the card.
     */
    public void setRank() {
        if (this.value == 11) {
            rank = 13;
        } else if (this.value < 10) {
            rank = this.value - 1;
        } else if (face.equals("Ten")) {
            rank = 9;
        } else if (face.equals("Jack")) {
            rank = 10;
        } else if (face.equals("Queen")) {
            rank = 11;
        } else if (face.equals("King")) {
            rank = 12;
        }
    }

    /**
     * Returns the state of this object as a String.
     * @return the string value of this face.
     */
    @Override                    // is this needed?
    public String toString() {
        return face;
    }
}

