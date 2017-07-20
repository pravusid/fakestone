package me.idpravus.domain;

import me.idpravus.data.CommonCards;
import me.idpravus.data.ClassCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CardInventory {
    protected LinkedList<Card> cards;

    protected CardInventory() { }

    // 인벤토리는 사용자마다 하나씩 주어지고, 생성과 동시에 모두 채워진다
    public CardInventory(AbstractHero hero) {
        cards = new LinkedList<>();
        generateCards(hero);
    }

    private void generateCards(AbstractHero hero) {
        for (CommonCards data : CommonCards.values()) {
            cards.add(createCard(data));
        }
        // 선택한 직업카드만 생성한다
        new ArrayList<ClassCards>(Arrays.asList(ClassCards.values()))
			        				.stream()
			        				.filter(c -> c.getHero() == hero)
			        				.forEach(c -> cards.add(createCard(c)));
    }

    // 카드 정보를 받아서 카드를 생성한다
    private Card createCard(AbstractCard data) {
        return new Card(data);
    }

    // 남아있는 카드목록을 보여달라고 요청한다
    public int showDeckDetail() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + 1 + ":" + cards.get(i) + " ");
        }
        return cards.size();
    }

    public Card getCard(int i) {
        // 요청이 들어온 카드를 반환하고, 반환하기전 인벤토리에서 삭제한다
        Card card = cards.get(i);
        cards.remove(card);
        return card;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

}
