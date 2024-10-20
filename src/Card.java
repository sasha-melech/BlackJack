/**
 * Class which represents cards.
 *
 * @param name You must write the Face and Suit enumeration
 * @author Caleb Register
 * @author Sasha Donaldson
 */

public record Card(Face name, Suit suit, boolean faceDown) {

    @Override
    public String toString() {
        return String.format("%5s of %s", name.toString(), suit.toString());
    }
}

enum Suit {
    SPADES ("Spades"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    final String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Face {
    ACE("Ace", 11),
    DUECE("Duece", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10);

    final String name;
    final int value;

    Face(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}

