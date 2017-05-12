public class OXgame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		startMenu(initBoard(new char[3][3]));

	}
	
	public static void startMenu (final char[][] board) {
		System.out.println("どれかを選択して下さい");
		System.out.println("1:2P対戦");
		System.out.println("2:CPU対戦");
		System.out.println("3:終了");
		System.out.print("> ");
		final int NUM = new java.util.Scanner(System.in).nextInt();
		switch (NUM) {
		case 1:
			doOXgame(board);
			break;
		case 2:
			doVsCPU(board);
			break;
		case 3:
			System.out.println("ゲームを終了します");
			break;
		default:
			System.out.println("正しい値を入力して下さい");
			break;
		}
	}
	
	public static void displayNumbers () {
		System.out.println("");
		System.out.println("  --- --- ---");
		System.out.println(" | 1 | 2 | 3 |");
		System.out.println("  --- --- ---");
		System.out.println(" | 4 | 5 | 6 |");
		System.out.println("  --- --- ---");
		System.out.println(" | 7 | 8 | 9 |");
		System.out.println("  --- --- ---");
		System.out.println("");
	}

	public static void doOXgame (char[][] board) {
		displayBoard(board);
		for (int i = 0; i < 9; i++) {
			displayNumbers();
			System.out.println((i % 2 == 0 ? 'O' : 'X') + "を入れたい所を入力して下さい");
			System.out.print("> ");
			board = inputOX(board, (i % 2 == 0 ? true : false));
			displayBoard(board);
			if(wonOX(board, 'O', 'X')) {
				break;
			}
		}
		System.out.println(
			wonOX(board, 'O', 'X')
				? (wonOX(board, 'O')
					? 'O'
					: 'X')
				+ "の勝ちです"
				: "引き分けです");
		System.out.println("ゲームを終了します");
	}
	
	public static void doVsCPU (char[][] board) {
		displayBoard(board);
		for (int i = 0; i < 9; i++) {
			displayNumbers();
			if (i % 2 == 0) {
				System.out.println("Oを入れたい所を入力して下さい");
				System.out.print("> ");
				board = inputOX(board, true);
				displayBoard(board);
			} else {
				board = inputOX(board, false, true, i);
				displayBoard(board);
			}
			if(wonOX(board, 'O', 'X')) {
				break;
			}
		}
		System.out.println(
			wonOX(board, 'O', 'X')
				? (wonOX(board, 'O')
					? 'O'
					: 'X')
				+ "の勝ちです"
				: "引き分けです");
		System.out.println("ゲームを終了します");
	}
	
	public static boolean wonOX(final char[][] BOARD, final char O_OR_X) {
		return (
			   (BOARD[0][0] == O_OR_X && BOARD[0][1] == O_OR_X && BOARD[0][2] == O_OR_X) 
			|| (BOARD[1][0] == O_OR_X && BOARD[1][1] == O_OR_X && BOARD[1][2] == O_OR_X) 
			|| (BOARD[1][0] == O_OR_X && BOARD[1][1] == O_OR_X && BOARD[1][2] == O_OR_X)

			|| (BOARD[0][0] == O_OR_X && BOARD[1][0] == O_OR_X && BOARD[2][0] == O_OR_X)
			|| (BOARD[0][1] == O_OR_X && BOARD[1][1] == O_OR_X && BOARD[2][1] == O_OR_X)
			|| (BOARD[0][2] == O_OR_X && BOARD[1][2] == O_OR_X && BOARD[2][2] == O_OR_X)
				
			|| (BOARD[0][0] == O_OR_X && BOARD[1][1] == O_OR_X && BOARD[2][2] == O_OR_X)
			|| (BOARD[0][2] == O_OR_X && BOARD[1][1] == O_OR_X && BOARD[2][0] == O_OR_X))
				? true
				: false;
	}

	public static boolean wonOX(final char[][] BOARD, final char O, final char X) {
		return (wonOX(BOARD, O) || wonOX(BOARD, X));
	}

	public static char[][] initBoard (char[][] board) {
		board[0][0] = ' ';
		board[0][1] = ' ';
		board[0][2] = ' ';
		board[1][0] = ' ';
		board[1][1] = ' ';
		board[1][2] = ' ';
		board[2][0] = ' ';
		board[2][1] = ' ';
		board[2][2] = ' ';
		return board;
	}
	
	public static char[][] inputOX (char[][] board, final boolean IS_O) {
		final char OX = IS_O ? 'O' : 'X';
		boolean done = false;
		while (!done) {
			switch (new java.util.Scanner(System.in).nextInt()) {
				case 1:
					board[0][0] = putOX(board[0][0], OX, false);
					done = isDone(board[0][0], OX);
					break;
				case 2:
					board[0][1] = putOX(board[0][1], OX, false);
					done = isDone(board[0][1], OX);
					break;
				case 3:
					board[0][2] = putOX(board[0][2], OX, false);
					done = isDone(board[0][2], OX);
					break;
				case 4:
					board[1][0] = putOX(board[1][0], OX, false);
					done = isDone(board[1][0], OX);
					break;
				case 5:
					board[1][1] = putOX(board[1][1], OX, false);
					done = isDone(board[1][1], OX);
					break;
				case 6:
					board[1][2] = putOX(board[1][2], OX, false);
					done = isDone(board[1][2], OX);
					break;
				case 7:
					board[2][0] = putOX(board[2][0], OX, false);
					done = isDone(board[2][0], OX);
					break;
				case 8:
					board[2][1] = putOX(board[2][1], OX, false);
					done = isDone(board[2][1], OX);
					break;
				case 9:
					board[2][2] = putOX(board[2][2], OX, false);
					done = isDone(board[2][2], OX);
					break;
				default:
					System.out.println("正しい値を入力して下さい");
			}
		}
		return board;
	}
	
	
	
	public static char[][] inputOX (char[][] board, final boolean IS_O, final boolean IS_CPU, final int i) {
		if (IS_CPU) {
			final char OX = IS_O ? 'O' : 'X';
			boolean done = false;
			while (!done) {
				//switch (new java.util.Random().nextInt(9) + 1) {
				switch (cpu(board, i)) {
					case 1:
						board[0][0] = putOX(board[0][0], OX, true);
						done = isDone(board[0][0], OX);
						break;
					case 2:
						board[0][1] = putOX(board[0][1], OX, true);
						done = isDone(board[0][1], OX);
						break;
					case 3:
						board[0][2] = putOX(board[0][2], OX, true);
						done = isDone(board[0][2], OX);
						break;
					case 4:
						board[1][0] = putOX(board[1][0], OX, true);
						done = isDone(board[1][0], OX);
						break;
					case 5:
						board[1][1] = putOX(board[1][1], OX, true);
						done = isDone(board[1][1], OX);
						break;
					case 6:
						board[1][2] = putOX(board[1][2], OX, true);
						done = isDone(board[1][2], OX);
						break;
					case 7:
						board[2][0] = putOX(board[2][0], OX, true);
						done = isDone(board[2][0], OX);
						break;
					case 8:
						board[2][1] = putOX(board[2][1], OX, true);
						done = isDone(board[2][1], OX);
						break;
					case 9:
						board[2][2] = putOX(board[2][2], OX, true);
						done = isDone(board[2][2], OX);
						break;
					default:
						//System.out.println("正しい値を入力して下さい");
				}
			}
		}
		return board;
	}
	
	public static int cpu (final char[][] BOARD, final int i) {
		final int num;
		System.out.println(i);
		if (i == 1) {
			if (BOARD[1][1] == ' ') {
				num = 5;
			} else if (BOARD[0][0] == ' '
					|| BOARD[0][2] == ' '
					|| BOARD[2][0] == ' '
					|| BOARD[2][2] == ' ') {
				if (BOARD[0][0] == ' ') {
					num = 1;
				} else if (BOARD[0][2] == ' ') {
					num = 3;
				} else if (BOARD[0][2] == ' ') {
					num = 7;
				} else {
					num = 9;
				}
			} else {
				num = new java.util.Random().nextInt(9) + 1;
			}
		} else if (BOARD[0][0] == ' ' && BOARD[0][1] == ' ') {
			num = 3;
		} else if (BOARD[0][0] == ' ' && BOARD[0][2] == ' ') {
			num = 2;
		} else if (BOARD[0][1] == ' ' && BOARD[0][2] == ' ') {
			num = 1;

		} else if (BOARD[1][0] == ' ' && BOARD[1][1] == ' ') {
			num = 6;
		} else if (BOARD[1][0] == ' ' && BOARD[1][2] == ' ') {
			num = 5;
		} else if (BOARD[1][1] == ' ' && BOARD[1][2] == ' ') {
			num = 4;

		} else if (BOARD[2][0] == ' ' && BOARD[2][1] == ' ') {
			num = 9;
		} else if (BOARD[2][0] == ' ' && BOARD[2][2] == ' ') {
			num = 8;
		} else if (BOARD[2][1] == ' ' && BOARD[2][2] == ' ') {
			num = 7;

		} else if (BOARD[2][1] == ' ' && BOARD[2][2] == ' ') {
			num = 7;
		} else {
			num = new java.util.Random().nextInt(9) + 1;
		}
		System.out.println(num);
		return num;
		//return new java.util.Random().nextInt(9) + 1;
	}
	
	public static char[][] setOX (char[][] board, final int NUM, final char OX, boolean done) {
		switch (NUM) {
			case 1:
				board[0][0] = putOX(board[0][0], OX, true);
				done = isDone(board[0][0], OX);
				break;
			case 2:
				board[0][1] = putOX(board[0][1], OX, true);
				done = isDone(board[0][1], OX);
				break;
			case 3:
				board[0][2] = putOX(board[0][2], OX, true);
				done = isDone(board[0][2], OX);
				break;
			case 4:
				board[1][0] = putOX(board[1][0], OX, true);
				done = isDone(board[1][0], OX);
				break;
			case 5:
				board[1][1] = putOX(board[1][1], OX, true);
				done = isDone(board[1][1], OX);
				break;
			case 6:
				board[1][2] = putOX(board[1][2], OX, true);
				done = isDone(board[1][2], OX);
				break;
			case 7:
				board[2][0] = putOX(board[2][0], OX, true);
				done = isDone(board[2][0], OX);
				break;
			case 8:
				board[2][1] = putOX(board[2][1], OX, true);
				done = isDone(board[2][1], OX);
				break;
			case 9:
				board[2][2] = putOX(board[2][2], OX, true);
				done = isDone(board[2][2], OX);
				break;
			default:
				System.out.println("正しい値を入力して下さい");
		}
		return board;
	}

	public static char putOX (final char BOARD, final char OX, final boolean IS_CPU) {
		if (!IS_CPU) {
			redo(BOARD, BOARD != ' ');
		}
		return (BOARD == ' ') ? OX : BOARD;
	}

	public static void redo (final char BOARD, final boolean NOT_EMPTY) {
		if (NOT_EMPTY) {
			System.out.println("既に" + BOARD + "が入っています");
			System.out.println("もう一度入力して下さい");
			System.out.print("> ");
		}
	}

	public static boolean isDone (final char BOARD, final char OX) {
		return (BOARD == OX ? true : false);
	}

	public static void displayBoard (final char[][] BOARD) {
		System.out.println("  --- --- ---");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" | ");
				System.out.print(BOARD[i][j]);
			}
		System.out.println(" |");
		System.out.println("  --- --- ---");
		}
	}
}