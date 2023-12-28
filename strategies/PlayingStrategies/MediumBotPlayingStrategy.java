package LLD3.TicTacToeDesign.strategies.PlayingStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Cell;
import LLD3.TicTacToeDesign.models.CellState;
import LLD3.TicTacToeDesign.models.Player;

import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    Random random;

    public MediumBotPlayingStrategy()
    {
        random = new Random();
    }
    @Override
    public Cell makeMove(Board board, List<Player> players) {
        //! generate uniform random row and colum within the given board dimension
        int row = -1;
        int col = -1;
        do{
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        }while(!validateRandomGeneratedRowAndCols(row, col, board));

        return board.getCells().get(row).get(col);
    }

    private boolean validateRandomGeneratedRowAndCols(int row, int col, Board board) {
        if(row<0 || row>=board.getSize() || col<0 || col>=board.getSize())
        {
            return false;
        }

        if(!CellState.EMPTY.equals(board.getCells().get(row).get(col).getCellState()))
        {
            return false;
        }
        return true;
    }
}
