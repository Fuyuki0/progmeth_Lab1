package logic;

import java.util.ArrayList;

public class UnitDeck {

    private String deckName;
    private ArrayList<UnitCard> deck;
    public UnitDeck(String deckName) {
        this.deckName = deckName;
    }

    public void addCard(UnitCard card, int cardAmount) {
        for (int i = 0; i < cardAmount; i++) deck.add(card);
    }

    public String getDeckName() {
        return deckName;
    }

    public void removeCard(UnitCard card, int cardAmount) {
        for (int i = 0; i < cardAmount; i++) deck.remove(card);

    }

    public boolean existsInDeck(UnitCard card) {
        int exist = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (card == deck.get(i)) exist++;
        }
        return exist != 0;
    }
}
