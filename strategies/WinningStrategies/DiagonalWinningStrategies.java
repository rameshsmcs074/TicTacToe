package LLD3.TicTacToeDesign.strategies.WinningStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategies implements WinningStrategies{

    Map<Character, Integer> lowerDiagonalFrequencyMaps;
    Map<Character, Integer> upperDiagonalFrequencyMaps;

    public DiagonalWinningStrategies(){
        lowerDiagonalFrequencyMaps = new HashMap<>();
        upperDiagonalFrequencyMaps = new HashMap<>();

    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        if(checkWinnerInLowerDiagonal(board, move) || checkWinnerInUpperDiagonal(board, move))
        {
            return true;
        }
        return false;
    }

    private boolean checkWinnerInUpperDiagonal(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        char symbol =  move.getPlayer().getSymbol();
        if((row+col) == board.getSize())
        {
            if(!upperDiagonalFrequencyMaps.containsKey(symbol))
            {
                upperDiagonalFrequencyMaps.put(symbol, 0);
            }

            //! update
            upperDiagonalFrequencyMaps.put(symbol, upperDiagonalFrequencyMaps.get(symbol)+1);

            if(upperDiagonalFrequencyMaps.get(symbol)==(board.getSize()))
            {
                System.out.println("Winning via upper diagonal");
                return true;
            }
        }
        return false;

    }

    private boolean checkWinnerInLowerDiagonal(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();
        if(row == col)
        {
            if(!lowerDiagonalFrequencyMaps.containsKey(symbol))
            {
                lowerDiagonalFrequencyMaps.put(symbol, 0);
            }

            //! update
            lowerDiagonalFrequencyMaps.put(symbol, lowerDiagonalFrequencyMaps.get(symbol)+1);

            if(lowerDiagonalFrequencyMaps.get(symbol)==(board.getSize()))
            {
                System.out.println("Winning via lower diagonal");
                return true;
            }
        }
        return false;

    }
}
