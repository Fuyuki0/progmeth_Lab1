package logic;

import java.util.ArrayList;

public class UnitDeck {

    private String deckName;
    private ArrayList<CardCounter> cardsInDeck;

    public UnitDeck(String deckName) {
        this.deckName = deckName;
        this.cardsInDeck = new ArrayList<>();
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public void addCard(UnitCard newCard, int cardAmount) {
        for (int i = 0; i < cardAmount; i++) cardsInDeck.add(new CardCounter(newCard, cardAmount));
    }

    public String getDeckName() {
        return deckName;
    }

    public void removeCard(UnitCard cardToRemove, int cardAmount) {
        for (int i = 0; i < cardAmount; i++) cardsInDeck.remove(new CardCounter(cardToRemove, cardAmount));

    }

    public int cardCount() {
        return cardsInDeck.size();
    }

    public boolean existsInDeck(UnitCard card) {
        int exist = 0;
        for (int i = 0; i < cardsInDeck.size(); i++) {
            if (card == cardsInDeck.get(i).getCard()) exist++;
        }
        return exist != 0;
    }

    public boolean equals(UnitDeck other) {
        return this.deckName.equals(other.deckName);
    }
}
