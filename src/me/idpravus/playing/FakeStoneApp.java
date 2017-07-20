package me.idpravus.playing;


import me.idpravus.data.Heroes;
import me.idpravus.domain.*;

import java.util.ArrayList;

public class FakeStoneApp {
    ArrayList<Player> players;
    ArrayList<Deck> decks;

    // 게임을 작동 시키는 영역, 필요한 인스턴스를 생성해서 보유하는 container 역할을 한다.
    public void initializeGame() {
        players = new ArrayList<>();
        decks = new ArrayList<>();
        DeckComposer deckComp = new DeckComposer();

        for (int i = 0; i < Rule.MAX_PLAYER; i++) {
            System.out.println("====================\n플레이어의 이름을 입력하세요");
            String name = IOManager.scanString();

            System.out.println("===== 직업 목록 =====");
            AbstractHero[] heroes = Heroes.values();
            for (int j = 0; j < heroes.length; j++) {
                System.out.print(j + 1 + "번:" + heroes[j].getName() + " ");
            }

            System.out.println("\n" + name + "의 직업을 선택하세요");
            int result = IOManager.scanNumber(heroes.length);
            AbstractHero hero = heroes[result];
            System.out.println("선택된 직업 : " + hero.getName());

            // 플레이어 생성 후 직업, 덱 설정
            Player player = new Player(name, hero);
            players.add(player);

            // 선택 한 직업으로 덱 설정
            CardInventory cardInv = new CardInventory(hero);
            Deck deck = new Deck();
            decks.add(deck);
            deckComp.configDeck(cardInv, decks.get(i));
        }
        startGame();
    }

    private void startGame() {
        System.out.println("==========\n사전 설정이 끝났습니다." +
                "\n게임을 시작하겠습니다\n시작순서는 임의로 결정됩니다\n==========");
        // 게임을 시작하기 위해서 가상의 결투장(게임진행자) 생성
        BattleField referee = new BattleField(players, decks);
        Player winner = referee.startGame();
        // 게임이 끝나면 승리자를 받아서 출력한다
        gameOver(winner);
    }

    private void gameOver(Player player) {
        if (player == null) {
            System.out.println("무승부");
            return;
        }
        System.out.println(player.getName() + "가 승리했습니다!!");
    }

}
