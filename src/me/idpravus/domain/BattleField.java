package me.idpravus.domain;

import me.idpravus.playing.IOManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BattleField {
    private ArrayList<Player> players;
    private ArrayList<Deck> decks;
    private Referee referee;
    // 규칙 관련 속성
    private int turn;
    // 카드 관련 속성
    private List<LinkedList<Card>> activeCards;
    private LinkedList<GameObject> deadCards;
    // 결과
    private Player winner;

    public BattleField(ArrayList<Player> players, ArrayList<Deck> decks) {
        this.players = players;
        this.decks = decks;
        this.referee = new Referee(this);
        // 게임 시작을 위한 환경 초기설정
        initialize();
    }

    private void initialize() {
        turn = Rule.FIRST_TURN;
        activeCards = new ArrayList<LinkedList<Card>>();
        deadCards = new LinkedList<GameObject>();
        for (int i = 0; i < Rule.MAX_PLAYER; i++) {
            activeCards.add(new LinkedList<Card>());
        }

        Collections.shuffle(players);
        System.out.println(players.get(0).getName() + "님이 먼저 시작합니다");
        for (Deck deck : decks) {
            deck.shuffleDeck();
        }

        // 시작하기전 플레이어들에게 카드를 지급한다
        for (int i = 0; i < Rule.MAX_PLAYER; i++) {
            for (int j = 0; j < Rule.INIT_CARDS; j++) {
                decks.get(i).drawCard(players.get(i));
            }
        }
    }

    /* 게임 시작지점 (GAMELOOP) */
    public Player startGame() {
        while (true) {
            try {
                displayStatus();
                for (Player player : players) {
                    manageTurn(player);
                }
                prepareNextTurn();
                if (turn > Rule.TURN_LIMIT) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if (winner != null) {
                    break;
                }
            }
        }
        return winner;
    }
    /* 게임 종료 시점(LOOP종료) */

    private void displayStatus() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }

        String display = "============================= " + turn + "턴 ==========================\n";
        for (int i = 1; i < players.size(); i += 2) {
            display += players.get(i) + "\n";
            display += "------------------------------------------------------------\n";
            for (Card card : activeCards.get(i)) {
                display += card + "\n";
            }
        }
        display += "------------------------------------------------------------\n";
        for (int i = 0; i < players.size(); i += 2) {
            for (Card card : activeCards.get(i)) {
                display += card + "\n";
            }
            display += "------------------------------------------------------------\n";
            display += players.get(i) + "\n";
        }
        display += "============================================================\n";
        System.out.println(display);
    }

    public void manageTurn(Player player) {
        while (true) {
            System.out.println("===== " + player + "님의 차례입니다 =====\n"
                    + "1.카드(핸드) 2.카드(필드) 3.영웅능력 4.턴 종료");
            int input = IOManager.scanNumber(4);
            if (input == 3) {
                break;
            }
            switch (input) {
                case 0:
                    player.useCardsInHand(this);
                    break;
                case 1:
                    referee.useCardsInField(players, player);
                    break;
                case 2:
                    player.heroPower(player, referee);
                    break;
            }
            // 행동을 마칠 때 마다 현재 상태 화면 출력
            displayStatus();
        }
    }

    public void prepareNextTurn() {
        turn++;
        // 각 플레이어는 다음턴을 준비하고, 덱에게 플레이어 대상 카드지급을 명령함
        for (int i = 0; i < Rule.MAX_PLAYER; i++) {
            players.get(i).nextTurn(turn);
            decks.get(i).drawCard(players.get(i));
        }
        // 카드 나이를 증가시킨다
        activeCards.stream().forEach(l -> l.stream().forEach(c -> c.nextTurn()));
    }

    public LinkedList<Card> getActiveCards(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == player) {
                return activeCards.get(i);
            }
        }
        return null;
    }

    // 플레이이가 등록요청한 카드를 필드에 추가해준다
    public void registCard(Player player, Card card) {
        getActiveCards(player).add(card);
    }

    // 카드를 필드에서 제거한다
    public void eliminateCard(GameObject card) {
        System.out.println(card.getName() + " 카드가 파괴되었습니다");
        deadCards.add(card);
        // TODO : 스트림 사용시 객체 자체가 삭제되는 문제 (다시 중첩반복문 적용)
        for (List<Card> list : activeCards) {
            for (Card c : list) {
                if (c == card) {
                    list.remove(c);
                }
            }
        }
    }

    public void setWinner(Player player) {
        players.remove(player);
        winner = players.get(0);
    }

}
