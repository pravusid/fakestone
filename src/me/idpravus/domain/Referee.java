package me.idpravus.domain;

import java.util.LinkedList;
import java.util.List;

import me.idpravus.data.GameObjectType;
import me.idpravus.playing.IOManager;

public class Referee {
	private BattleField field;

	public Referee(BattleField field) {
		this.field = field;
	}

	public void useCardsInField(List<Player> players, Player player) {
		LinkedList<Card> cards = validOnCards(field.getActiveCards(player));
		if (!IOManager.listAvailability(cards)) {
			return;
		}
		System.out.println("===== 사용할 카드를 선택하세요 =====");
		IOManager.printList(cards);
		int input = IOManager.scanNumber(cards.size());

		System.out.println("===== 대상(목표)를 선택하세요 =====");
		List<GameObject> targets = searchTargets(players, player);
		IOManager.printList(targets);
		int target = IOManager.scanNumber(targets.size());
		calculateResult(player, cards.get(input), targets.get(target));
	}

	// 카드 유효성 검증 (공격력이 0이거나, 현재턴에 필드에 생성한 카드)
	private LinkedList<Card> validOnCards(List<Card> cards) {
		LinkedList<Card> revisedList = new LinkedList<>();
		cards.stream()
				.filter(c -> c.getAtk() != 0 && c.getAge() > 0 && c.isActive())
				.forEach(c -> revisedList.add(c));
		return revisedList;
	}

	private List<GameObject> searchTargets(List<Player> players, Player player) {
		List<GameObject> list = new LinkedList<>();
		List<GameObject> filter = new LinkedList<>();

		// 도발카드가 있는지 확인한다
		players.stream()
				.filter(p -> p != player)
				.forEach(p -> field.getActiveCards(p).stream()
						.filter(c -> c.getType().equals(GameObjectType.MINION_TAUNT))
						.forEach(c -> filter.add(c)));
		if (!filter.isEmpty()) { return filter; }

		players.stream()
				.filter(p -> p != player).forEach(p -> list.add(p));
		players.stream()
				.filter(p -> p != player).forEach(p -> list.addAll(field.getActiveCards(p)));
		return list;
	}
	
	// 두 게임 오브젝트를 비교하여 공방을 주고받고 결과를 전송한다
	public void calculateResult(Player player, Card card, GameObject target) {
		boolean gameOver = false;
		// 카드 비활성화 (턴 소비)
		card.deactivate();
		
		if (target.getType().equals(GameObjectType.HERO)) {
			gameOver = ((Player)target).damaged(card.getAtk());
			
		} else {
			int targetHP = target.getDef() - card.getAtk();
			if (targetHP > 0) {
				((Card)target).setDef(targetHP);
			} else {
				field.eliminateCard(target);
			}
			
			int cardHP = card.getDef() - target.getAtk();
			if (cardHP > 0) {
				card.setDef(cardHP);
			} else {
				field.eliminateCard(card);
			}
		}
		
		if (gameOver) {
			field.setWinner(player);
			throw new RuntimeException("승리자가 결정되었습니다");
		}
	}

}
