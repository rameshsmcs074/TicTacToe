package LLD3.TicTacToeDesign.strategies.WinningStrategies;
import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Move;

public interface WinningStrategies {
    boolean checkWinner(Board board, Move move);
}
