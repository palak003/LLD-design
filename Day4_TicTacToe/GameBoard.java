package Day4_TicTacToe;

import java.util.Scanner;

public class GameBoard {
    private final int size = 3;
    private final PlayerSymbol[][] grid = new PlayerSymbol[size][size];
    private GameState gameState = GameState.IN_PROGRESS;
    private PlayerSymbol current = PlayerSymbol.X;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        // initialize empty board
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = null;

        // game loop
        while (gameState == GameState.IN_PROGRESS) {
            printBoard();
            System.out.printf("Player %s, enter row and column (0-%d): ", current, size-1);
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            if (!validateMove(i, j) || grid[i][j] != null) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            grid[i][j] = current;
            updateGameState(i, j);

            if (gameState == GameState.IN_PROGRESS) {
                current = (current == PlayerSymbol.X) ? PlayerSymbol.O : PlayerSymbol.X;
            }
        }

        printBoard();
        switch (gameState) {
            case X_WINS -> System.out.println("Player X wins!");
            case O_WINS -> System.out.println("Player O wins!");
            default     -> System.out.println("Draw!");
        }
    }

    private boolean validateMove(int i, int j) {
        return i >= 0 && j >= 0 && i < size && j < size;
    }

    private void updateGameState(int row, int col) {
        if (isWinner(row, col, current)) {
            gameState = (current == PlayerSymbol.X) ? GameState.X_WINS : GameState.O_WINS;
        } else if (isDraw()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean isWinner(int r, int c, PlayerSymbol sym) {
        // row -
        boolean win = true;
        for (int j = 0; j < size; j++)
            if (grid[r][j] != sym) { win = false; break; }
        if (win) return true;

        // column |
        win = true;
        for (int i = 0; i < size; i++)
            if (grid[i][c] != sym) { win = false; break; }
        if (win) return true;

        // main diagonal \
        if (r == c) {
            win = true;
            for (int i = 0; i < size; i++)
                if (grid[i][i] != sym) { win = false; break; }
            if (win) return true;
        }

        // anti-diagonal /
        if (r + c == size - 1) {
            win = true;
            for (int i = 0; i < size; i++)
                if (grid[i][size-1-i] != sym) { win = false; break; }
            if (win) return true;
        }

        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == null)
                    return false;
        return true;
    }

    private void printBoard() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] == null ? "_" : grid[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
