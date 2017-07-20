package me.idpravus.data;

import me.idpravus.domain.AbstractCard;
import me.idpravus.domain.Player;
import me.idpravus.domain.Referee;

public enum CommonCards implements AbstractCard {
	// 카드 개별 특수능력 구현 예시
	// 특수능력은 중복되는 부분이 있으므로 한 곳에 모아서 구현, 여기에서는 호출만
    Stonetusk_Boar(GameObjectType.MINION, "돌엄니 멧돼지", 1, 1, 1) {
    	@Override
    	public boolean cardPower(Player player, Referee referee) {
    		System.out.println("돌엄니 멧돼지 특수능력");
    		return true;
    	}
    },
    Murloc_Raider(GameObjectType.MINION, "멀록 약탈꾼", 1, 2, 1),
    Voodoo_Doctor(GameObjectType.MINION, "부두교 의술사 ", 1, 2, 1),
    Grimscale_Oracle(GameObjectType.MINION, "성난비늘 수련사", 1, 1, 1),
    Elven_Archer(GameObjectType.MINION, "엘프 궁수", 1, 1, 1),
    Goldshire_Footman(GameObjectType.MINION_TAUNT, "황금골 보병", 1, 1, 2),
    Murloc_Tidehunter(GameObjectType.MINION, "멀록 바다사냥꾼", 2, 2, 1),
    Murloc_Scout(GameObjectType.MINION, "멀록 정찰병", 1, 1, 1),
    River_Crocolisk(GameObjectType.MINION, "민물악어", 2, 2, 3),
    Bloodfen_Raptor(GameObjectType.MINION, "붉은늪지랩터", 2, 3, 2),
    Acidic_Swamp_Ooze(GameObjectType.MINION, "산성 늪수액괴물", 2, 3, 2),
    Frostwolf_Grunt(GameObjectType.MINION_TAUNT, "서리늑대 그런트", 2, 2, 2),
    Kobold_Geomancer(GameObjectType.MINION, "코볼트 흙점쟁이", 2, 2, 2),
    Bluegill_Warrior(GameObjectType.MINION, "푸른아가미 전사", 2, 2, 1),
    Novice_Engineer(GameObjectType.MINION, "풋내기 기술자", 2, 1, 1),
    Razorfen_Hunter(GameObjectType.MINION, "가시덩굴 사냥꾼", 3, 2, 3),
    Raid_Leader(GameObjectType.MINION, "공격대장", 3, 2, 2),
    Wolfrider(GameObjectType.MINION, "늑대기수", 3, 3, 1),
    Dalaran_Mage(GameObjectType.MINION, "달라란 마법사", 3, 1, 4),
    Shattered_Sun_Cleric(GameObjectType.MINION, "무너진 태양 성직자", 3, 3, 2),
    Ironfur_Grizzly(GameObjectType.MINION_TAUNT, "무쇠가죽 불곰", 3, 3, 3),
    Ironforge_Rifleman(GameObjectType.MINION, "아이언포지 소총병", 3, 2, 2),
    Silverback_Patriarch(GameObjectType.MINION_TAUNT, "은빛털고릴라 우두머리", 3, 1, 4),
    Dragonling_Mechanic(GameObjectType.MINION, "기계용 정비사", 4, 2, 4),
    Mechanical_Dragonling(GameObjectType.MINION, "소형 기계용", 1, 2, 1),
    Gnomish_Inventor(GameObjectType.MINION, "노움 발명가", 4, 2, 4),
    Chillwind_Yeti(GameObjectType.MINION, "서리바람 설인", 4, 4, 5),
    Senjin_Shieldmasta(GameObjectType.MINION_TAUNT, "센진 방패대가", 4, 3, 5),
    Stormwind_Knight(GameObjectType.MINION, "스톰윈드 기사", 4, 2, 5),
    Oasis_Snapjaw(GameObjectType.MINION_TAUNT, "오아시스 무쇠턱거북", 4, 2, 7),
    Ogre_Magi(GameObjectType.MINION, "오우거 마법사", 4, 4, 4),
    Gurubashi_Berserker(GameObjectType.MINION, "구루바시 광전사", 5, 2, 7),
    Booty_Bay_Bodyguard(GameObjectType.MINION_TAUNT, "무법항 경호원", 5, 5, 4),
    Frostwolf_Warlord(GameObjectType.MINION, "서리늑대 전쟁군주", 5, 4, 4),
    Stormpike_Commando(GameObjectType.MINION, "스톰파이크 특공대", 5, 4, 2),
    Nightblade(GameObjectType.MINION, "암흑칼날", 5, 4, 4),
    Darkscale_Healer(GameObjectType.MINION, "어둠비늘 치유사", 5, 4, 5),
    Archmage(GameObjectType.MINION, "대마법사", 6, 4, 7),
    Boulderfist_Ogre(GameObjectType.MINION, "돌주먹 오우거", 6, 6, 7),
    Reckless_Rocketeer(GameObjectType.MINION, "못 말리는 로켓병", 6, 5, 2),
    Lord_of_the_Arena(GameObjectType.MINION_TAUNT, "투기장의 제왕", 6, 6, 5),
    Stormwind_Champion(GameObjectType.MINION, "스톰윈드 용사", 7, 6, 6),
    Core_Hound(GameObjectType.MINION, "심장부 사냥개", 7, 9, 5),
    War_Golem(GameObjectType.MINION, "전쟁 골렘", 7, 7, 7);

	private GameObjectType type;
    private String name;
    private int cost;
    private int atk;
    private int def;

    CommonCards(GameObjectType type, String name, int cost, int atk, int def) {
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
