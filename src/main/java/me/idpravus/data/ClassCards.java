package me.idpravus.data;

import me.idpravus.domain.AbstractCard;
import me.idpravus.domain.AbstractHero;

public enum ClassCards implements AbstractCard {
    Warsong_Commander(GameObjectType.MINION, Heroes.WARRIOR, "전쟁노래 사령관", 3, 2, 3),
    Korkron_Elite(GameObjectType.MINION, Heroes.WARRIOR, "코르크론 정예병", 4, 4, 3),
    Cruel_Taskmaster(GameObjectType.MINION, Heroes.WARRIOR, "잔인한 감독관", 2, 2, 2),
    Arathi_Weaponsmith(GameObjectType.MINION, Heroes.WARRIOR, "아라시 무기제작자", 4, 3, 3),
    Armorsmith(GameObjectType.MINION, Heroes.WARRIOR, "방어구 제작자", 2, 1, 4),
    Frothing_Berserker(GameObjectType.MINION, Heroes.WARRIOR, "거품 무는 광전사", 3, 2, 4),

    Flametongue_Totem(GameObjectType.MINION, Heroes.SHAMAN, "불꽃의 토템", 2, 0, 3),
    Windspeaker(GameObjectType.MINION, Heroes.SHAMAN, "바람예언자", 4, 3, 3),
    Fire_Elemental(GameObjectType.MINION, Heroes.SHAMAN, "불의 정령", 6, 6, 5),
    Dust_Devil(GameObjectType.MINION, Heroes.SHAMAN, "먼지 악령", 1, 3, 1),
    Unbound_Elemental(GameObjectType.MINION, Heroes.SHAMAN, "속박 풀린 정령", 3, 2, 4),
    Mana_Tide_Totem(GameObjectType.MINION, Heroes.SHAMAN, "마나 해일 토템", 3, 0, 3),

    Defias_Ringleader(GameObjectType.MINION, Heroes.ROGUE, "데피아즈단 두목", 2, 2, 2),
    SI7_Agent(GameObjectType.MINION, Heroes.ROGUE, "SI:7 요원", 3, 3, 3),
    Master_of_Disguise(GameObjectType.MINION, Heroes.ROGUE, "위장의 대가", 4, 4, 4),
    Patient_Assassin(GameObjectType.MINION, Heroes.ROGUE, "침착한 암살자", 2, 1, 1),
    Kidnapper(GameObjectType.MINION, Heroes.ROGUE, "납치범", 6, 5, 3),
    Edwin_VanCleef(GameObjectType.MINION, Heroes.ROGUE, "에드윈 밴클리프", 3, 2, 2),

    Guardian_of_Kings(GameObjectType.MINION, Heroes.PALADIN, "왕의 수호자", 7, 5, 6),
    Argent_Protector(GameObjectType.MINION, Heroes.PALADIN, "여명회 파수병", 2, 2, 2),
    Aldor_Peacekeeper(GameObjectType.MINION, Heroes.PALADIN, "알도르 평화감시단", 3, 3, 3),

    Timber_Wolf(GameObjectType.MINION, Heroes.HUNTER, "회갈색 늑대", 1, 1, 1),
    Houndmaster(GameObjectType.MINION, Heroes.HUNTER, "사냥개조련사", 4, 4, 3),
    Starving_Buzzard(GameObjectType.MINION, Heroes.HUNTER, "굶주린 대머리수리", 5, 3, 2),
    Tundra_Rhino(GameObjectType.MINION, Heroes.HUNTER, "툰드라 코뿔소", 5, 2, 5),
    Scavenging_Hyena(GameObjectType.MINION, Heroes.HUNTER, "청소부 하이에나", 2, 2, 2),

    Ironbark_Protector(GameObjectType.MINION, Heroes.DRUID, "무쇠껍질 수호정령", 8, 8, 8),
    Druid_of_the_Claw(GameObjectType.MINION, Heroes.DRUID, "발톱의 드루이드", 5, 4, 4),
    Keeper_of_the_Grove(GameObjectType.MINION, Heroes.DRUID, "숲의 수호자", 4, 2, 2),
    Ancient_of_War(GameObjectType.MINION, Heroes.DRUID, "전쟁의 고대정령", 7, 5, 5),
    Ancient_of_Lore(GameObjectType.MINION, Heroes.DRUID, "지식의 고대정령", 7, 5, 5),

    Voidwalker(GameObjectType.MINION, Heroes.WARLOCK, "공허방랑자", 1, 1, 3),
    Succubus(GameObjectType.MINION, Heroes.WARLOCK, "서큐버스", 2, 4, 3),
    Dread_Infernal(GameObjectType.MINION, Heroes.WARLOCK, "공포의 지옥불정령", 6, 6, 6),
    Blood_Imp(GameObjectType.MINION, Heroes.WARLOCK, "피의 임프", 1, 0, 1),
    Flame_Imp(GameObjectType.MINION, Heroes.WARLOCK, "화염 임프", 1, 3, 2),
    Void_Terror(GameObjectType.MINION, Heroes.WARLOCK, "공허의 괴물", 3, 3, 3),

    Water_Elemental(GameObjectType.MINION, Heroes.MAGE, "물의 정령", 4, 3, 6),
    Mana_Wyrm(GameObjectType.MINION, Heroes.MAGE, "마나 지룡", 1, 1, 3),
    Sorcerers_Apprentice(GameObjectType.MINION, Heroes.MAGE, "마술사의 수습생", 2, 3, 2),
    Kirin_Tor_Mage(GameObjectType.MINION, Heroes.MAGE, "키린 토 마법사", 3, 4, 3),
    Ethereal_Arcanist(GameObjectType.MINION, Heroes.MAGE, "에테리얼 비전술사", 4, 3, 3),

    Northshire_Cleric(GameObjectType.MINION, Heroes.PRIEST, "북녘골 성직자", 1, 1, 3),
    Lightspawn(GameObjectType.MINION, Heroes.PRIEST, "빛의 정령", 4, 0, 5),
    Temple_Enforcer(GameObjectType.MINION, Heroes.PRIEST, "사원 집행자", 6, 6, 6),
    Lightwell(GameObjectType.MINION, Heroes.PRIEST, "빛샘", 2, 0, 5),
    Cabal_Shadow_Priest(GameObjectType.MINION, Heroes.PRIEST, "비밀결사단 어둠사제", 6, 4, 5);

    private GameObjectType type;
    private AbstractHero hero;
    private String name;
    private int cost;
    private int atk;
    private int def;

    ClassCards(GameObjectType type, AbstractHero hero, String name, int cost, int atk, int def) {
        this.type = type;
        this.hero = hero;
        this.name = name;
        this.cost = cost;
        this.atk = atk;
        this.def = def;
    }

    public AbstractHero getHero() {
        return hero;
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
