package LLD3.TicTacToeDesign.strategies.PlayingStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Cell;
import LLD3.TicTacToeDesign.models.Player;

import java.util.List;

public interface BotPlayingStrategy {
    Cell makeMove(Board board, List<Player> players);
}
