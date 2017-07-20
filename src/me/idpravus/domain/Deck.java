package me.idpravus.domain;

import java.util.Collections;
import java.util.LinkedList;

import me.idpravus.playing.IOManager;

public final class Deck extends CardInventory {

    public Deck() {
        cards = new LinkedList<>();
    }

    public String addCard(Card card) {
        // 덱이 보유한 카드 수가 30 초과인지 확인 && 직업 카드가 맞는지 확인
        if (cards.size()>Rule.DECK_LIMIT) {
            throw new RuntimeException("덱이 가득 찼습니다");
        }
        cards.add(card);
        return "카드를 추가 했습니다";
    }
    
    public void shuffleDeck() {
    	Collections.shuffle(cards);
    }

    public Card drawCard(Player player) {
        // 덱의 첫번째 카드를 반환하고, 반환하기전 인벤토리에서 삭제한다
        if (cards.isEmpty()) {
        	System.out.println("덱에 카드가 없습니다");
        	return null;
        }
    	Card card = cards.pop();
        player.addCardToHand(card);
        return card;
    }

}
