package me.idpravus.domain;

import me.idpravus.data.GameObjectType;

public class Card implements AbstractCard {
	// 카드 원본 정보
	private AbstractCard data;
	// 사용하는 정보 (기능에따라 값 변화 가능)
	private int cost;
	private int atk;
	private int def;
	private int age;
	private boolean isActive;

	public Card(AbstractCard data) {
		this.data = data;
		this.cost = data.getCost();
		this.atk = data.getAtk();
		this.def = data.getDef();
		this.isActive = false;
	}

	public int getAge() {
		return age;
	}
	
	public void setDef(int def) {
		this.def = def;
	}

	public void nextTurn() {
		age++;
		isActive = true;
	}

	public boolean isActive() {
		return isActive;
	}
	
	public void deactivate() {
		isActive = false;
	}

	@Override
	public GameObjectType getType() {
		return data.getType();
	}

	@Override
	public String getName() {
		return data.getName();
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public int getAtk() {
		return atk;
	}

	@Override
	public int getDef() {
		return def;
	}

	@Override
	public boolean cardPower(Player player, Referee referee) {
		return data.cardPower(player, referee);
	}

	@Override
	public String toString() {
		return data.getName() + "(cost=" + cost + ",atk=" + atk + ",def=" + def + ")" + getType();
	}

}
