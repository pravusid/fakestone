package me.idpravus.playing;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import me.idpravus.domain.Card;
import me.idpravus.domain.GameObject;

public class IOManager {

	public static String scanString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static int scanNumber(int maximum) {
		int result = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				result = scan.nextInt();
			} catch (InputMismatchException e) {
			} finally {
				if (result > 0 && result <= maximum) {
					break;
				} else {
					System.out.println("잘못된 입력 값 입니다.");
				}
			}
		}
		return result - 1;
	}

	public static int getRandomInt(int maximum) {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		return rand.nextInt(maximum);
	}

	public static void printList(List<? extends GameObject> objList) {
		String display = new String();
		for (int i = 0; i < objList.size(); i++) {
			display += "[" + (i + 1) + "]" + objList.get(i) + "\n";
		}
		System.out.println(display);
	}

	public static boolean listAvailability(List<? extends GameObject> objList) {
		if (objList.isEmpty()) {
			System.out.println("사용가능한 개체가 없습니다");
			return false;
		}
		return true;
	}

}
