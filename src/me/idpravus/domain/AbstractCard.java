package me.idpravus.domain;

public interface AbstractCard extends GameObject {
	
	// default interface 사용
	default public boolean cardPower(Player player, Referee referee) {
    	System.out.println("카드에 특수능력 없음");
    	return false;
    }
	
}
