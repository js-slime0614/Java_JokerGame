package game;

import java.util.Arrays;
import java.util.Scanner;

class Card {

	public String[] trumpCard = new String[53];
	public String[] PlayerCard = new String[27];
	public String[] EnemyCard = new String[26];
	String PlayerOneName;
	String PlayerTwoName;
	// ������ �������� �˻��� ����
	public boolean GameEnd = false;
	// �÷��̾��� �迭 ����
	public final int PlayerCnt = 27;
	// ���ʹ��� �迭 ����
	public final int EnemyCnt = 26;
	//�÷��̾� ī���� ����
	public int playerCardNum;
	//���ʹ� ī���� ����
	public int enemyCardNum;

	// �÷��̾��� �г��� ����
	public void SetNickname() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�÷��̾� 1 �� �г��� �Է� : ");
		PlayerOneName = sc.next();
		System.out.print("�÷��̾� 2 �� �г��� �Է� : ");
		PlayerTwoName = sc.next();
		
	}
	// ī�� �� (�����Ҷ� ī��迭�� ī�带 ��������)
	public void CardSet() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				switch (i + 1) {
				case 1:
					trumpCard[cnt] = "��" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				case 2:
					trumpCard[cnt] = "��" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				case 3:
					trumpCard[cnt] = "��" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				case 4:
					trumpCard[cnt] = "��" + (j == 0 ? "A" : (j == 10) ? "J" : (j == 11 ? "Q" : (j == 12 ? "K" : j + 1)));
					break;
				}
				cnt++;
			}
		}
		trumpCard[52] = "JOKER";
	}

	// ī�� ��� (ī����� ���������� �۵��ߴ��� ����ϴ� �뵵)
	void printCard() {
		for (int i = 0; i < 53; i++) {
			System.out.println(trumpCard[i]);
		}
	}

	// ī�� ��� ( �ڽŰ� ������ ī�带 �������)
	void cardDistribute() {
		// ������ ���� ��� �������� ����
		int randomTemp;
		int PlayerCnt = 0;
		int EnemyCnt = 0;
		int i = 0;
		while (i < trumpCard.length) {
			// �÷��̾�� ī�� ���
			if (i % 2 == 0) {
				// Ʈ���� ī���� ������ ���� ���� null �� �ƴҶ����� ������ ���� ����
				while (true) {
					randomTemp = (int) (Math.random() * 53);
					//System.out.println("�����Ѽ� ���" + randomTemp);
					if (trumpCard[randomTemp] != null) {
						//System.out.println("��������");
						break;
					}
					//System.out.println("��ħ");
				}
				;
				// �÷��̾��� ���°�� ���� ������ ���
				//System.out.println("PlayerCard ��" + PlayerCnt + "��° �迭��" + trumpCard[randomTemp] + " ����");
				// ī�� ���
				PlayerCard[PlayerCnt] = trumpCard[randomTemp];
				// �̹� ���� ī��� null�� ó��
				trumpCard[randomTemp] = null;
				//System.out.println("null�� ����� Ȯ�ο�" + trumpCard[randomTemp]);
				// �����Ѽ� �ʱ�ȭ
				randomTemp = 0;
				PlayerCnt++;
			}
			// ������ ī�� ���
			else {
				// Ʈ���� ī���� ������ ���� ���� null �� �ƴҶ����� ������ ���� ����
				while (true) {
					randomTemp = (int) (Math.random() * 53);
					//System.out.println("�����Ѽ� ���" + randomTemp);
					if (trumpCard[randomTemp] != null) {
						//System.out.println("��������");
						break;
					}
					//System.out.println("��ħ");
				}
				;
				// ���ʹ��� ���°�� ���� ������ ���
				//System.out.println("EnemyCard ��" + EnemyCnt + "��° �迭��" + trumpCard[randomTemp] + " ����");
				EnemyCard[EnemyCnt] = trumpCard[randomTemp];
				trumpCard[randomTemp] = null;
				//System.out.println("null�� ����� Ȯ�ο�" + trumpCard[randomTemp]);
				randomTemp = 0;
				EnemyCnt++;
			}
			i++;
		}
	}
	// �÷��̾� �� ��� ī�� ��� ( ����� �糪 Ȯ�ο� )
	void printPlayerOneCard() throws InterruptedException {
		//�÷��̾�, ���ʹ� ī�� �ʱ�ȭ
		playerCardNum = 26;
		enemyCardNum = 25;
		System.out.println("===" + PlayerOneName + " ī�� Ȯ��===");
		for (int i = 0; i < 27; i++) {
			if (PlayerCard[i] != " ") {
				Thread.sleep(200);
				System.out.print(PlayerCard[i] + " ");
				playerCardNum--;
			}
		}
		//System.out.println("===�� ī�� Ȯ��===");
		for (int i = 0; i < 26; i++) {
			if (EnemyCard[i] != " ") {
				//System.out.println(EnemyCard[i]);
				enemyCardNum--;
			}
		}
		System.out.println();
	}
	void printPlayerTwoCard() throws InterruptedException {
		//�÷��̾�, ���ʹ� ī�� �ʱ�ȭ
		playerCardNum = 26;
		enemyCardNum = 25;
		//System.out.println("===�÷��̾� ī�� Ȯ��===");
		for (int i = 0; i < 27; i++) {
			if (PlayerCard[i] != " ") {
				
				//System.out.println(PlayerCard[i]);
				playerCardNum--;
			}
		}
		System.out.println("===" + PlayerTwoName + " ī�� Ȯ��===");
		for (int i = 0; i < 26; i++) {
			if (EnemyCard[i] != " ") {
				Thread.sleep(200);
				System.out.print(EnemyCard[i] + " ");
				enemyCardNum--;
			}
		}
		System.out.println();
	}

	// ���ڰ� ��ġ�� ī�� �ѽ� �� ���ֱ�
	void removePair() {

		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < PlayerCnt; j++) {
				// �÷��̾��� �� ���ڰ� ���ٸ� ���� ���� �������
				if ((PlayerCard[i].substring(1).equals(PlayerCard[j].substring(1)) && i != j) && PlayerCard[i] != " ") {
					System.out.println("����" + PlayerCard[i] + " " + PlayerCard[j]);
					PlayerCard[i] = " ";
					PlayerCard[j] = " ";
				}
			}
			if (i < 26) {
				for (int j = 0; j < EnemyCnt; j++) {
					// ���ʹ��� �� ���ڰ� ���ٸ� ���� ���� �������
					if ((EnemyCard[i].substring(1).equals(EnemyCard[j].substring(1)) && i != j)
							&& EnemyCard[i] != " ") {
						System.out.println("����" + EnemyCard[i] + " " + EnemyCard[j]);
						EnemyCard[i] = " ";
						EnemyCard[j] = " ";
					}
				}
			}
		}
		Arrays.sort(PlayerCard);
		Arrays.sort(EnemyCard);
	}
	//ī�� �̱� 
	public void selectCard() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int anyTempNum = 100;
		System.out.println(PlayerTwoName + " �� ī�� ���� :" + (EnemyCnt - enemyCardNum - 1));
		while(anyTempNum >= (EnemyCnt - enemyCardNum) && anyTempNum > 0) {
			System.out.println("�̰���� ī���� ��ȣ�� �Է� �ϼ���.");
			anyTempNum = sc.nextInt();
		}
		int selectRandomNum = enemyCardNum + ((int)(Math.random() * (EnemyCnt - enemyCardNum - 1)) + 1);
		//System.out.println(selectRandomNum - enemyCardNum);
		System.out.print(PlayerOneName + "��(��) ���� ī�� : ");
		Thread.sleep(500);
		System.out.println(EnemyCard[selectRandomNum]);
		PlayerCard[playerCardNum-1] = EnemyCard[selectRandomNum];
		EnemyCard[selectRandomNum] = " ";
		removePair();
		printPlayerTwoCard();
		gameOver();
		if(GameEnd == false) {
			anyTempNum = 100;
			System.out.println(PlayerOneName + "�� ī�� ���� :" + (PlayerCnt - playerCardNum - 1));
			while(anyTempNum >= (PlayerCnt - playerCardNum) && anyTempNum > 0) {
				System.out.println("�̰���� ī���� ��ȣ�� �Է� �ϼ���.");
				anyTempNum = sc.nextInt();
			}
			selectRandomNum = playerCardNum + ((int)(Math.random() * (PlayerCnt - playerCardNum - 1)) + 1);
			//System.out.println(selectRandomNum - enemyCardNum);
			System.out.print(PlayerTwoName + "��(��) ���� ī�� : ");
			Thread.sleep(500);
			System.out.println(PlayerCard[selectRandomNum]);
			EnemyCard[enemyCardNum - 1] = PlayerCard[selectRandomNum];
			PlayerCard[selectRandomNum] = " ";
			removePair();
			printPlayerOneCard();
			gameOver();
//			System.out.printf("��밡 ī�带 �̴���");
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
//			System.out.printf("\n��밡 ���� ī�� : " + PlayerCard[selectRandomNum] + "\n");
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
		// �г��� ����
		card.SetNickname();
		// ī�� ����
		card.CardSet();
		// ī�� ���� �Ǿ��� ��� �غ��� ( �ӽ�
		// card.printCard();
		// ī�� ����ϱ�
		card.cardDistribute();
		// ���� �Ʊ��� ī�����	( �ӽ�
		//card.printPlayerEnemyCard();
		// �� ���ڰ� ��ġ�� �� ����
		card.removePair();
		//�÷��̾� 1 ī�� ���
		card.printPlayerOneCard();
		//�÷��̾� 2 ī�� ���
		card.printPlayerTwoCard();
		while(card.GameEnd == false) {
			//ī�� ����
			card.selectCard();
		}
	}
}
