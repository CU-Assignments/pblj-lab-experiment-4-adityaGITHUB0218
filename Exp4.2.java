Experiment 4.2: Card Collection System

code :

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Card {
    private String suit;
    private String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return rank.equals(card.rank) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return rank.hashCode() ^ suit.hashCode();
    }
}

class CardCollection {
    private Map<String, Set<Card>> cardsBySuit;

    public CardCollection() {
        cardsBySuit = new HashMap<>();
    }

    public void addCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        cardsBySuit.putIfAbsent(suit, new HashSet<>());
        if (cardsBySuit.get(suit).contains(card)) {
            System.out.println("Error: Card \"" + card + "\" already exists.");
        } else {
            cardsBySuit.get(suit).add(card);
            System.out.println("Card added: " + card);
        }
    }

    public void findCardsBySuit(String suit) {
        Set<Card> cards = cardsBySuit.get(suit);
        if (cards != null && !cards.isEmpty()) {
            for (Card card : cards) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public void displayAllCards() {
        boolean found = false;
        for (Set<Card> cards : cardsBySuit.values()) {
            for (Card card : cards) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found.");
        }
    }

    public void removeCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        Set<Card> cards = cardsBySuit.get(suit);
        if (cards != null && cards.remove(card)) {
            System.out.println("Card removed: " + card);
        } else {
            System.out.println("Card not found: " + card);
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        CardCollection collection = new CardCollection();

        System.out.println("Test Case 1: Display All Cards");
        collection.displayAllCards();

        System.out.println("\nTest Case 2: Adding Cards");
        collection.addCard("Ace", "Spades");
        collection.addCard("King", "Hearts");
        collection.addCard("10", "Diamonds");
        collection.addCard("5", "Clubs");

        System.out.println("\nTest Case 3: Finding Cards by Suit");
        collection.findCardsBySuit("Hearts");

        System.out.println("\nTest Case 4: Searching Suit with No Cards");
        collection.findCardsBySuit("Diamonds");


        System.out.println("\nTest Case 5: Displaying All Cards");
        collection.displayAllCards();

        System.out.println("\nTest Case 6: Preventing Duplicate Cards");
        collection.addCard("King", "Hearts");

        System.out.println("\nTest Case 7: Removing a Card");
        collection.removeCard("10", "Diamonds");
    }
}

Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds
