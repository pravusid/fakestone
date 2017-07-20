package me.idpravus.domain;

import java.util.LinkedList;
import java.util.List;

import me.idpravus.data.GameObjectType;
import me.idpravus.playing.IOManager;

public final class Player implements AbstractHero {
    private String name;
    private AbstractHero hero;
    private List<Card> hand;
    private int HP;
    private int shield;
    private int maxMana;
    private int curMana;
    
    // 플레이어 생성과 함께 초기화
    public Player(String name, AbstractHero hero) {
    	this.name = name;
    	this.hero = hero;
    	hand = new LinkedList<>();
    	this.HP = Rule.MAX_HP;
    	this.maxMana = Rule.INIT_MANA;
    	this.curMana = Rule.INIT_MANA;
    }
    
    public String getName() {
        return name;
    }
    
    public void nextTurn(int turn) {
    	if (turn <= 10) { maxMana = turn; }
    	curMana = maxMana;
    }

    public void addCardToHand(Card card) {
    	hand.add(card);
    }
    
    public void useCardsInHand(BattleField field) {
    	if (!IOManager.listAvailability(hand)) { return; }
		IOManager.printList(hand);
		
		int input = IOManager.scanNumber(hand.size());
		Card card = hand.get(input);
		
		// MANA 확인한 뒤 부족하면 실행안함
		if (calcMana(card.getCost())) {
			hand.remove(card);
			field.registCard(this, card);
		}
    }
    
    private boolean calcMana(int cost) {
    	if (curMana < cost) {
			System.out.println("마나가 부족합니다");
			return false;
		}
    	curMana -= cost;
    	return true;
    }
    
    public boolean damaged(int damage) {
		if (shield >= damage) {
			shield -= damage;
		} else {
			HP = HP + shield - damage; 
		}
		if (HP > 0) { System.out.println(name + "님이 공격받아 체력이 " + HP +" 남았습니다"); }
		return (HP > 0)? false: true;
	}
    
    @Override
    public GameObjectType getType() {
    	return hero.getType();
    }
    
	@Override
	public int getCost() {
		return hero.getCost();
	}

	@Override
	public int getAtk() {
		return hero.getAtk();
	}

	@Override
	public int getDef() {
		return hero.getDef();
	}

	@Override
	public void heroPower(Player player, Referee referee) {
		int cost = hero.getCost();
		if (calcMana(cost)) { hero.heroPower(player, referee); }
	}
	
    @Override
    public String toString() {
    	return name+" {"+hero.getName()+"("+HP+")}"
    			+" MANA:" + curMana + "/" + maxMana;
    }

}
