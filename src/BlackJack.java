import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    /** The computer player */
    private Player computer;
    /** A deck of cards */
    private Card[] deck;
    /** The size of a deck of cards */
    static final int DECK_SIZE = 52;
    /** The human player */
    private Player player;
    /** Input from the console. */
    private final Scanner scanIn = new Scanner(System.in);
    /** Index of the card at the top of the deck */
    private int topCard;

    public BlackJack() {
        enterPlayerName();

        deck = new Card[DECK_SIZE]; //Initializes the size of the array in pack
        int cardNum = 0;
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                deck[cardNum++] = new Card(face, suit, false);
            }
        }

    }

    /**
     * The computer player takes a turn.
     */
    private void computerTurn() {
        boolean hasBlackjack = computer.getHandType() == HandType.BJACK;
        boolean under16 = computer.handValue() < 16;
        boolean attemptFiveCardTrick = computer.handValue() < 19 && player.isFull();
        if (!hasBlackjack && under16 || attemptFiveCardTrick) {
            // TODO: add computer turn
        }
    }

    /**
     * Deal one card to a player, and advance the top card to be the next card.
     * @param player
     * @param faceUp
     */
    void dealOne(Player player, boolean faceUp) {
        ;
    }

    /**
     * Build up a string containing the game's results and return it.
     * @return
     */
    String determineResults() {
        ;
    }

    /**
     * Allow the player to enter their name.
     */
    void enterPlayerName() {
        System.out.println("Enter your name > ");
        player = new Player(scanIn.nextLine());
    }

    /**
     * Convert the computer and player's hands to a String and return it.
     * @return
     */
    String formatHands() {
        ;
    }

    /**
     * Helper method to determine the winner.
     * @param player
     * @param computer
     * @return
     */
    private String formatWinner(Player player, Player computer) {
        ;
    }

    /**
     * Get a reference to the computer player.
     * @return
     */
    Player getComputerPlayer() {
        return computer;
    }

    /**
     * Get a reference to the deck.
     * @return
     */
    Card[] getDeck() {
        return deck;
    }

    /**
     * Get a reference to the human player.
     * @return
     */
    Player getHumanPlayer() {
        return player;
    }

    /**
     * Ask the player to enter their name and then play a round of Blackjack.
     */
    void go() {
        ;
    }

    /**
     * Initialize a deck of cards (without Jokers).
     */
    void initDeck() {
        ;
    }

    /**
     * Main for testing the Blackjack class -- not required for the project.
     * @param args
     */
    static void main(String[] args) {
        ;
    }

    /**
     * Play one round of BlackJack.
     */
    void oneRound() {
        ;
    }

    /**
     * Prompts the player if they would like another card with a "H"/"S" response, case insensitive.
     */
    private void playerTurn() {
        ;
    }

    /**
     * The Fisher-Yates Shuffle.
     */
    void shuffle() {
        Random random = new Random();
        for (int i = 0; i < DECK_SIZE; i++) {
            int j = random.nextInt(DECK_SIZE);
            swap(i, j);
        }
    }

    /**
     * Swap two cards in the deck.
     * @param one The first card.
     * @param two The second card.
     */
    private void swap(int one, int two) {
        Card temp = deck[one];
        deck[one] = deck[two];
        deck[two] = temp;
    }
}
