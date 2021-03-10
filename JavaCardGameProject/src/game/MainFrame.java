package game;

import java.util.Arrays;
import java.util.Scanner;

class Card {

	public String[] trumpCard = new String[53];
	public String[] PlayerCard = new String[27];
	public String[] EnemyCard = new String[26];
	String PlayerOneName;
	String PlayerTwoName;
	// 게임이 끝났는지 검사할 변수
	public boolean GameEnd = false;
	// 플레이어의 배열 갯수
	public final int PlayerCnt = 27;
	// 에너미의 배열 갯수
	public final int EnemyCnt = 26;
	//플레이어 카드의 갯수
	public int playerCardNum;
	//에너미 카드의 갯수
	public int enemyCardNum;

	// 플레이어의 닉네임 지정
	public void SetNickname() {
		Scanner sc = new Scanner(System.in);
		System.out.print("플레이어 1 의 닉네임 입력 : ");
		PlayerOneName = sc.next();
		System.out.print("플레이어 2 의 닉네임 입력 : ");
		PlayerTwoName = sc.next();
		
	}
	// 카드 셋 (시작할때 카드배열에 카드를 설정해줌)
	public void CardSet() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				switch (i + 1) {
				case 1:
					trumpCard[cnt] = "♠" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				case 2:
					trumpCard[cnt] = "◆" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				case 3:
					trumpCard[cnt] = "♥" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				case 4:
					trumpCard[cnt] = "♣" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				}
				cnt++;
			}
		}
		trumpCard[52] = "JOKER";
	}

	// 카드 출력 (카드셋이 정상적으로 작동했는지 출력하는 용도)
	void printCard() {
		for (int i = 0; i < 53; i++) {
			System.out.println(trumpCard[i]);
		}
	}

	// 카드 배분 ( 자신과 적에게 카드를 배분해줌)
	void cardDistribute() {
		// 랜덤한 수를 잠깐 저장해줄 변수
		int randomTemp;
		int PlayerCnt = 0;
		int EnemyCnt = 0;
		int i = 0;
		while (i < trumpCard.length) {
			// 플레이어에게 카드 배분
			if (i % 2 == 0) {
				// 트럼프 카드의 랜덤한 수의 값이 null 이 아닐때까지 랜덤한 수를 정함
				while (true) {
					randomTemp = (int) (Math.random() * 53);
					//System.out.println("랜덤한수 출력" + randomTemp);
					if (trumpCard[randomTemp] != null) {
						//System.out.println("빠져나옴");
						break;
					}
					//System.out.println("겹침");
				}
				;
				// 플레이어의 몇번째에 뭐가 들어갔는지 출력
				//System.out.println("PlayerCard 의" + PlayerCnt + "번째 배열에" + trumpCard[randomTemp] + " 가들어감");
				// 카드 배분
				PlayerCard[PlayerCnt] = trumpCard[randomTemp];
				// 이미 받은 카드는 null로 처리
				trumpCard[randomTemp] = null;
				//System.out.println("null이 됬는지 확인용" + trumpCard[randomTemp]);
				// 랜덤한수 초기화
				randomTemp = 0;
				PlayerCnt++;
			}
			// 적에게 카드 배분
			else {
				// 트럼프 카드의 랜덤한 수의 값이 null 이 아닐때까지 랜덤한 수를 정함
				while (true) {
					randomTemp = (int) (Math.random() * 53);
					//System.out.println("랜덤한수 출력" + randomTemp);
					if (trumpCard[randomTemp] != null) {
						//System.out.println("빠져나옴");
						break;
					}
					//System.out.println("겹침");
				}
				;
				// 에너미의 몇번째에 뭐가 들어갔는지 출력
				//System.out.println("EnemyCard 의" + EnemyCnt + "번째 배열에" + trumpCard[randomTemp] + " 가들어감");
				EnemyCard[EnemyCnt] = trumpCard[randomTemp];
				trumpCard[randomTemp] = null;
				//System.out.println("null이 됬는지 확인용" + trumpCard[randomTemp]);
				randomTemp = 0;
				EnemyCnt++;
			}
			i++;
		}
	}
	// 플레이어 와 상대 카드 출력 ( 배분이 됬나 확인용 )
	void printPlayerOneCard() throws InterruptedException {
		//플레이어, 에너미 카드 초기화
		playerCardNum = 26;
		enemyCardNum = 25;
		System.out.println("===" + PlayerOneName + " 카드 확인===");
		for (int i = 0; i < 27; i++) {
			if (PlayerCard[i] != " ") {
				Thread.sleep(200);
				System.out.print(PlayerCard[i] + " ");
				playerCardNum--;
			}
		}
		//System.out.println("===적 카드 확인===");
		for (int i = 0; i < 26; i++) {
			if (EnemyCard[i] != " ") {
				//System.out.println(EnemyCard[i]);
				enemyCardNum--;
			}
		}
		System.out.println();
	}
	void printPlayerTwoCard() throws InterruptedException {
		//플레이어, 에너미 카드 초기화
		playerCardNum = 26;
		enemyCardNum = 25;
		//System.out.println("===플레이어 카드 확인===");
		for (int i = 0; i < 27; i++) {
			if (PlayerCard[i] != " ") {
				
				//System.out.println(PlayerCard[i]);
				playerCardNum--;
			}
		}
		System.out.println("===" + PlayerTwoName + " 카드 확인===");
		for (int i = 0; i < 26; i++) {
			if (EnemyCard[i] != " ") {
				Thread.sleep(200);
				System.out.print(EnemyCard[i] + " ");
				enemyCardNum--;
			}
		}
		System.out.println();
	}

	// 숫자가 겹치는 카드 한쌍 씩 없애기
	void removePair() {

		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < PlayerCnt; j++) {
				// 플레이어의 뒤 문자가 같다면 공백 으로 집어넣음
				if ((PlayerCard[i].substring(1).equals(PlayerCard[j].substring(1)) && i != j) && PlayerCard[i] != " ") {
					System.out.println("제거" + PlayerCard[i] + " " + PlayerCard[j]);
					PlayerCard[i] = " ";
					PlayerCard[j] = " ";
				}
			}
			if (i < 26) {
				for (int j = 0; j < EnemyCnt; j++) {
					// 에너미의 뒤 문자가 같다면 공백 으로 집어넣음
					if ((EnemyCard[i].substring(1).equals(EnemyCard[j].substring(1)) && i != j)
							&& EnemyCard[i] != " ") {
						System.out.println("제거" + EnemyCard[i] + " " + EnemyCard[j]);
						EnemyCard[i] = " ";
						EnemyCard[j] = " ";
					}
				}
			}
		}
		Arrays.sort(PlayerCard);
		Arrays.sort(EnemyCard);
	}
	//카드 뽑기 
	public void selectCard() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int anyTempNum = 100;
		System.out.println(PlayerTwoName + " 의 카드 갯수 :" + (EnemyCnt - enemyCardNum - 1));
		while(anyTempNum >= (EnemyCnt - enemyCardNum) && anyTempNum > 0) {
			System.out.println("뽑고싶은 카드의 번호를 입력 하세요.");
			anyTempNum = sc.nextInt();
		}
		int selectRandomNum = enemyCardNum + ((int)(Math.random() * (EnemyCnt - enemyCardNum - 1)) + 1);
		//System.out.println(selectRandomNum - enemyCardNum);
		System.out.print(PlayerOneName + "이(가) 뽑은 카드 : ");
		Thread.sleep(500);
		System.out.println(EnemyCard[selectRandomNum]);
		PlayerCard[playerCardNum-1] = EnemyCard[selectRandomNum];
		EnemyCard[selectRandomNum] = " ";
		removePair();
		printPlayerTwoCard();
		gameOver();
		if(GameEnd == false) {
			anyTempNum = 100;
			System.out.println(PlayerOneName + "의 카드 갯수 :" + (PlayerCnt - playerCardNum - 1));
			while(anyTempNum >= (PlayerCnt - playerCardNum) && anyTempNum > 0) {
				System.out.println("뽑고싶은 카드의 번호를 입력 하세요.");
				anyTempNum = sc.nextInt();
			}
			selectRandomNum = playerCardNum + ((int)(Math.random() * (PlayerCnt - playerCardNum - 1)) + 1);
			//System.out.println(selectRandomNum - enemyCardNum);
			System.out.print(PlayerTwoName + "이(가) 뽑은 카드 : ");
			Thread.sleep(500);
			System.out.println(PlayerCard[selectRandomNum]);
			EnemyCard[enemyCardNum - 1] = PlayerCard[selectRandomNum];
			PlayerCard[selectRandomNum] = " ";
			removePair();
			printPlayerOneCard();
			gameOver();
//			System.out.printf("상대가 카드를 뽑는중");
//			for(int i = 1; i <= 3; i ++) {
//				for (int j = 0; j < 3; j++) {
//					Thread.sleep(250);
//					System.out.print(".");
//				}
//				Thread.sleep(250);
//				System.out.print(i);
//			}
//			selectRandomNum = playerCardNum + ((int)(Math.random() * (PlayerCnt - playerCardNum - 1)) + 1);
//			//System.out.println(selectRandomNum - playerCardNum);
//			System.out.println();
//			System.out.printf("\n상대가 뽑은 카드 : " + PlayerCard[selectRandomNum] + "\n");
//			EnemyCard[enemyCardNum-1] = PlayerCard[selectRandomNum];
//			PlayerCard[selectRandomNum] = " ";
//			removePair();
//			printPlayerEnemyCard();
//			gameOver();
		}
	}
	void gameOver() {
		
		if((EnemyCnt - enemyCardNum - 1) == 0) {
			System.out.println("======" + PlayerTwoName + "Win!!======");
			GameEnd = true;
		}
		if(playerCardNum == 26) {
			System.out.println("======" + PlayerOneName + "Win!!======");
			GameEnd = true;
		}
	}
}

public class MainFrame {

	public static void main(String[] args) throws InterruptedException {
		Card card = new Card();
		// 닉네임 설정
		card.SetNickname();
		// 카드 설정
		card.CardSet();
		// 카드 설정 되었나 출력 해보기 ( 임시
		// card.printCard();
		// 카드 배분하기
		card.cardDistribute();
		// 적과 아군의 카드출력	( 임시
		//card.printPlayerEnemyCard();
		// 뒤 문자가 겹치는 것 삭제
		card.removePair();
		//플레이어 1 카드 출력
		card.printPlayerOneCard();
		//플레이어 2 카드 출력
		card.printPlayerTwoCard();
		while(card.GameEnd == false) {
			//카드 고르기
			card.selectCard();
		}
	}
}
