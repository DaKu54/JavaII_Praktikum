package quartet;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardDeck implements Comparator<card> {
    private List<Card> cards;

    public CardDeck() {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card removeFirstCard(){
        if(cards.isEmpty())
        {
            return null;
        }
        else {
            return cards.remove(0);
        }
    }

    public void addCard(Card card) throws CardDeckException {
        if(card==null)
        {
            throw new IllegalArgumentException("Card darf nicht null sein");
        }
        else if(cards.contains(card))
        {
            throw new CardDeckException("Card ist bereits in Deck vorhanden");
        }
    }

    public void allAllCards(CardDeck cardDeck)
    {
        for(Card card : cardDeck.cards)
        {
            this.cards.add(card);
            cardDeck.cards.remove(card);
        }
    }

    public void shuffleCards()
    {
        Collections.shuffle(this.cards);
    }

    public int size()
    {
        int i = 0;

        for(Card card: cards)
        {
            i++;
        }

        return i;
    }

    public boolean isEmpty()
    {
        if(cards.isEmpty())
            return true;
        else
            return false;
    }

    private class CardComparator implements java.util.Comparator<Card> {
        @Override
        public int compare(Card o1, Card o2) {
            return 0;
        }
    }
}
