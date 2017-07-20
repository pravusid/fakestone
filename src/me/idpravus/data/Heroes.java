package me.idpravus.data;

import me.idpravus.domain.AbstractHero;
import me.idpravus.domain.Player;
import me.idpravus.domain.Referee;

public enum Heroes implements AbstractHero {
	
	// ENUM_NAME("명칭", "마나소비량", "특수능력-공격", "특수능력-방어")
	// heroPower() -> 공격/회복, 실드 이외의 능력사용시
	MAGE(GameObjectType.HERO, "마법사", 2, 2, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("마법사 특수능력");
		}
	},
	PRIEST(GameObjectType.HERO, "사제", 2, -2, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("사제 특수능력");
		}
	},
	WARLOCK(GameObjectType.HERO, "흑마법사", 2, 0, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("흑마법사 특수능력");
		}
	},
	PALADIN(GameObjectType.HERO, "성기사", 2, 0, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("성기사 특수능력");
		}
	},
	WARRIOR(GameObjectType.HERO, "전사", 2, 0, 1) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("전사 특수능력");
		}
	},
	DRUID(GameObjectType.HERO, "드루이드", 2, 0, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("드루이드 특수능력");
		}
	},
	HUNTER(GameObjectType.HERO, "사냥꾼", 2, 2, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("사냥꾼 특수능력");
		}
	},
	ROGUE(GameObjectType.HERO, "도적", 2, 0, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("도적 특수능력");
		}
	},
	SHAMAN(GameObjectType.HERO, "주술사", 2, 0, 0) {
		@Override
		public void heroPower(Player player, Referee referee) {
			System.out.println("주술사 특수능력");
		}
	};

	private GameObjectType type;
	private String name;
	private int cost;
	private int atk;
	private int def;

	Heroes(GameObjectType type, String name, int cost, int atk, int def) {
		this.type = type;
		this.name = name;
		this.cost = cost;
		this.atk = atk;
		this.def = def;
	}
	
	@Override
	public GameObjectType getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
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

}
