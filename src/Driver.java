/**
 * Simple class to play a game of black jack.
 *
 * @author William Kreahling
 * @version February 2024
 */
public class Driver {
    /**
     * Entry point to play a game of black jack.
     * @param args not used.
     */
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.go();
    }
}
