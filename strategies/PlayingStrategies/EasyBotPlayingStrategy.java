package LLD3.TicTacToeDesign.strategies.PlayingStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Cell;
import LLD3.TicTacToeDesign.models.CellState;
import LLD3.TicTacToeDesign.models.Player;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board, List<Player> players) {
        for(List<Cell> row: board.getCells())
        {
            for(Cell cell: row)
            {
                if(CellState.EMPTY.equals(cell.getCellState()))
                {
                    return cell;
                }
            }
        }
        return null;
    }
}
