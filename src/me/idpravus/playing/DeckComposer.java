package me.idpravus.playing;

import me.idpravus.domain.CardInventory;
import me.idpravus.domain.Deck;
import me.idpravus.domain.Rule;

public class DeckComposer {
	
	public void configDeck(CardInventory cardInv, Deck deck) {
    	// 랜덤 생성여부를 물어본다
    	System.out.println("===== 덱을 랜덤으로 생성하시겠습니까? =====\n1. 네, 2. 아니오");
    	int isRand = IOManager.scanNumber(2);
		generateDeck(cardInv, deck, isRand);
    }

    private void generateDeck(CardInventory cardInv, Deck deck, int isRand) {
    	int num = 0;
        while (true) {
        	if (isRand == 0) {
        		num = IOManager.getRandomInt(cardInv.getCards().size());
        	} else if (isRand==1) {
        		System.out.println("===== 덱에 추가할 카드를 선택하세요 =====");
        		num = IOManager.scanNumber(cardInv.showDeckDetail());
        	}
    		deck.addCard(cardInv.getCard(num));
    		System.out.println("===== 현재 나의 덱 ======");
    		if (deck.showDeckDetail() == Rule.DECK_LIMIT) { break; }
        }
    }
    
}
