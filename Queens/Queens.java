public class Queens {
  private static final int BOARD_SIZE = ;

  enum State {
    EMPTY, QUEEN, RESTRICTED
  }

  public static State[][] placeQueens(State[][] board, int count) {
    if (count == 0) {
      printBoard(board);
      return board;
    }

    while (emptyExists(board)) {
      int[] empty = findEmpty(board);
      State[][] newBoard = placeQueens(addQueen(copyBoard(board), empty[0], empty[1]), count - 1);

      if (newBoard == null) {
        board[empty[0]][empty[1]] = State.RESTRICTED;
      } else {
        return board;
      }
    }

    return null;
  }

  private static boolean emptyExists(State[][] board) {
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[row][col] == State.EMPTY) {
          return true;
        }
      }
    }

    return false;
  }

  private static int[] findEmpty(State[][] board) {
    int[] coords = new int[2];

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[row][col] == State.EMPTY) {
          coords[0] = row;
          coords[1] = col;
        }
      }
    }

    return coords;
  }

  private static boolean solved(State[][] board, int count) {
    int n = 0;

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[row][col] == State.QUEEN) {
          n++;
        }
      }
    }

    return n == count;
  }

  private static State[][] addQueen(State[][] board, int r, int c) {
    for (int row = 0; row < BOARD_SIZE; row++) {
      board[row][c] = State.RESTRICTED;
    }

    for (int col = 0; col < BOARD_SIZE; col++) {
      board[r][col] = State.RESTRICTED;
    }

    int row = r;
    int col = c;
    while (row >= 0 && col >= 0) {
      board[row][col] = State.RESTRICTED;
      row--;
      col--;
    }

    row = r;
    col = c;
    while (row < BOARD_SIZE && col < BOARD_SIZE) {
      board[row][col] = State.RESTRICTED;
      row++;
      col++;
    }

    row = r;
    col = c;
    while (row < BOARD_SIZE && col >= 0) {
      board[row][col] = State.RESTRICTED;
      row++;
      col--;
    }

    row = r;
    col = c;
    while (row >= 0 && col < BOARD_SIZE) {
      board[row][col] = State.RESTRICTED;
      row--;
      col++;
    }

    board[r][c] = State.QUEEN;

    return board;
  }

  public static void printBoard(State[][] board) {
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[row][col] == State.EMPTY) {
          System.out.print("- ");
        }
        if (board[row][col] == State.RESTRICTED) {
          System.out.print("X ");
        }
        if (board[row][col] == State.QUEEN) {
          System.out.print("O ");
        }
      }
      System.out.println("");
    }

    System.out.println("");
  }

  private static State[][] copyBoard(State[][] oldBoard) {
    State[][] newBoard = new State[BOARD_SIZE][BOARD_SIZE];

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        newBoard[row][col] = oldBoard[row][col];
      }
    }

    return newBoard;
  }

  public static void main(String[] args) {
    State[][] board = new State[BOARD_SIZE][BOARD_SIZE];

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        board[row][col] = State.EMPTY;
      }
    }

    placeQueens(board, 8);
  }
}