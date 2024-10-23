import java.util.Objects;
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
        computer = new Player("Computer");
        enterPlayerName();
        initDeck();
    }

    /**
     * The computer player takes a turn.
     */
    private void computerTurn() {
        System.out.println("\nComputer's Turn\n========");
        while ((!(computer.getHandType() == HandType.BJACK) &&
                 (computer.handValue() < 16)) ||
                 (computer.handValue() < 19 && player.cardCount() == 4)) {
            dealOne(computer, false);
            System.out.println("Computer dealt another card.");
            System.out.println(formatHands());
        }
    }

    /**
     * Deal one card to a player, and advance the top card to be the next card.
     * @param player
     * @param faceUp
     */
    void dealOne(Player player, boolean faceUp) {
        Card cardDealt = deck[topCard++];
        if (faceUp) {
            cardDealt.setFaceUp();
        }
        else {
            cardDealt.setFaceDown();
        }
        player.addCard(cardDealt);
    }

    /**
     * Build up a string containing the game's results and return it.
     * @return
     */
    String determineResults() {
        String results = "\n\nResults\n==========%s\n%s";
        return String.format(results, formatHands(), formatWinner(computer, player));
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
        return player.toString()  + computer.toString();
    }

    /**
     * Helper method to determine the winner.
     * @param player
     * @param computer
     * @return
     */
    public static String formatWinner(Player player, Player computer) {
        String winnerMessage = "%s wins with a %s.";
        int winIndicator = player.compareTo(computer);
        if (winIndicator > 0) {
            winnerMessage = String.format(winnerMessage, player.getName(), player.getHandType().toString());
        }
        if (winIndicator < 0) {
            winnerMessage = String.format(winnerMessage, computer.getName(), computer.getHandType().toString());
        }
        else if (winIndicator == 0) {
            winnerMessage = "The game was a tie.";
        }
        winnerMessage = "\n" + winnerMessage + "\n";
        return winnerMessage;
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
        shuffle();
        String response = "";
        while (!response.equals("n")) {
            oneRound();
            boolean repeat = false;
            while (!repeat) {
                System.out.println("Play again? (Y/N) >");
                response = scanIn.next();
                response = response.toLowerCase();
                if (response.equals("y") || response.equals("n")) {
                    repeat = true;
                }
            }
            player.clearCards();
            computer.clearCards();
        }
    }

    /**
     * Initialize a deck of cards (without Jokers).
     */
    void initDeck() {
        deck = new Card[DECK_SIZE]; //Initializes the size of the array in pack
        int cardNum = 0;
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                deck[cardNum++] = new Card(face, suit, false);
            }
        }
    }

    /**
     * Play one round of BlackJack.
     */
    void oneRound() {
        if (52 - topCard <= 22) {
            shuffle();
        }
        dealOne(computer, true);
        dealOne(player, true);
        dealOne(computer, false);
        dealOne(player, true);
        System.out.println(formatHands());

        playerTurn();
        computerTurn();

        player.turnCardsUp();
        computer.turnCardsUp();
        System.out.println(determineResults());
    }

    /**
     * Prompts the player if they would like another card with a "H"/"S" response, case-insensitive.
     */
    private void playerTurn() {
        System.out.println("\n" + player.getName() + "'s Turn:\n========");
        char response = 'q';
        while (response != 's' && !player.isFull() && !(player.handValue() > 21)) {
            System.out.print("Hit or Stay(H/S)? >");
            response = scanIn.next().charAt(0);
//            response = 'H';
            response = Character.toLowerCase(response);
            if (response == 'h') {
                dealOne(player, true);
                System.out.println(player.toString());
            }
            else if (response != 's'){
                System.out.println("Enter a valid response");
            }
        }
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
        topCard = 0;
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
