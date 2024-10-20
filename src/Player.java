public class Player {
    /** Current number of cards in a player's hand */
    private int cardsInHand;
    /** A player hand */
    private Card[] hand;
    /** Max cards a player can have */
    private static final int MAX_CARDS = 5;
    /** The player's name */
    private String name;

    public Player(String name) {

    }

    public Player() {
        this("Player");
    }

    /**
     * Add a card to a player's hand.
     * @param card
     * @return
     */
    boolean addCard(Card card) {
        ;
    }

    /**
     * Get the number of cards in the player's hand.
     * @return
     */
    int cardCount() {
        return hand.length;
    }

    /**
     * Clear the cards in the player's hand.
     */
    void clearCards() {
        hand = new Card[MAX_CARDS];
    }

    /**
     * Computer this hand with the otherPlayer.
     * @param otherPlayer
     * @return
     */
    int compareTo(Player otherPlayer) {
        ;
    }

    /**
     * Get a card in the player's hand.
     * @param index
     * @return
     */
    Card getCard(int index) {
        ;
    }

    /**
     * Return the hand type of the player.
     * @return
     */
    HandType getHandType() {
        ;
    }

    /**
     * Get the player's name.
     * @return
     */
    String getName() {
        ;
    }

    /**
     * Add up the value of each card in the player's hand.
     * @return
     */
    int handValue() {
        int total = 0;
        for (Card card : hand) {
            total += card.name().getValue();
        }
        return total;
    }

    /**
     * Does this hand total to 21 in less than or equal to value number of cards?
     * @param value
     * @return
     */
    private boolean isBlackJack(int value) {
        ;
    }

    /**
     * It this player's hand bust, that is a value of over 21.
     * @return boolean indicating if a player's hand is greater than 21.
     */
    private boolean isBust() {
        return handValue() > 21;
    }

    /**
     * Determine if the player's hand has reached the card limit.
     * @return boolean indicating of a player's hand greater than or equal to the card limit.
     */
    boolean isFull() {
        return hand.length >= MAX_CARDS;
    }

    /**
     * Set a card in the players hand.
     * @param index The index of the card set.
     * @param card The new card.
     */
    void setCard(int index, Card card) {
        hand[index] = card;
    }

    /**
     * Set the player's name.
     * @param name The new player name.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Create a String representing the current state of the object.
     * @return String expressing the hand.
     */
    @Override
    public String toString() {
        String string = "";
        for (Card card : hand) {
            string = string + card + "|\t";
        }
        return string;
    }

    /**
     * Makes all the cards in the player's hand be face up.
     */
    void turnCardsUp() {
        ;
    }



}
