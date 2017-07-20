package me.idpravus.data;

public enum GameObjectType {
	HERO("영웅"),
	MINION("하수인"),
	MINION_TAUNT("하수인_도발"),
	SPELL("주문"),
	EQUIPABLE_WEAPONS("무기");
	
	private String type;
	
	GameObjectType(String type) {
		this.type = type;
	}
	
}
