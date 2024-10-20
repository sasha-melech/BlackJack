/**
 * Defines the hand types that are in the game of BlackJack.  The values are in order of
 * precedence with the first being a better hand than its next one. This enables their ordinal
 * values to be used for comparison purposes.
 * 
 * @author William Kreahling
 * @author Andrew Scott
 * @version Spring 2024
 */
public enum HandType {
    /** Blackjack */    
    BJACK("Blackjack"), 
    /** Twenty-one with exactly 5 cards */
    TRICK_5("Twenty one in five cards -- 5 TRICK"), 
    /** Twenty-one with 3-4 cards */
    FOUR_OR_LESS("Twenty one in four or less"), 
    /** Twenty-one with 6+ cards */
    SIX_OR_MORE("Twenty one in more than five cards"), 
    /** Under Twenty one */    
    TOTAL("Scoring hand"), 
    /** Over Twenty one */    
    BUST("Bust!!");

    /** The name to display on screen **/
    private final String NAME;

    /**
     * Construct and enum with a name.
     * @param name the name to display when printed.
     */
     private HandType(String name) {
         NAME = name;
     }
    
    /**
     * Convert the enum to its displayable name.
     * @return The display name for this hand type.
     */
    @Override
    public String toString() {
        return NAME;
    }
}
