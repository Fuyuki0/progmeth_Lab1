package logic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for (UnitCard c : list) if (card.getFlavorText().equals(c.getFlavorText())) return true;
		return false;
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for (UnitDeck d : list) if (deck.getDeckName().equals(d.getDeckName())) return true;
		return false;
	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck d : deckList) for (CardCounter c : d.getCardsInDeck()) {
			if (cardToTest.getName().equals(c.getCard().getFlavorText())) return true;
		};
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		InputStream inputStream = CardUtil.class.getClassLoader().getResourceAsStream(filename);
		if (inputStream == null) {
				System.out.println("Cannot find file!");
				return null;
		}

		Scanner myReader = new Scanner(inputStream);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] dataParts = data.split(",");

			String first = "";
			int second = 0;
			int third = 0;
			int forth = 0;
			String fifth = "";

			for (int i = 0; i < dataParts.length; i++) {

				switch (i) {
					case 0 -> {
						first = dataParts[i].strip();
					}
					case 1 -> {
						second = Integer.parseInt(dataParts[i]);
					}
					case 2 -> {
						third = Integer.parseInt(dataParts[i]);
					}
					case 3 -> {
						forth = Integer.parseInt(dataParts[i]);
					}
					case 4 -> {
						fifth = dataParts[i].strip();
					}
				}
			}
			cardsFromFile.add(new UnitCard(first, second, third, forth, fifth));
		}

		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
