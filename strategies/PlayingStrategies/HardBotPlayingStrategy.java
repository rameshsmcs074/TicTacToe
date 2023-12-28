package LLD3.TicTacToeDesign.strategies.PlayingStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Cell;
import LLD3.TicTacToeDesign.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardBotPlayingStrategy implements BotPlayingStrategy{

    private Map<Integer, Integer> rowFrequency;
    private Map<Integer, Integer> colFrequency;
    private Map<Character, Integer> lowerDiagonalFrequency;
    private Map<Character, Integer> upperDiagonalFrequency;

    public HardBotPlayingStrategy() {
        rowFrequency = new HashMap<>();
        colFrequency = new HashMap<>();
        lowerDiagonalFrequency = new HashMap<>();
        upperDiagonalFrequency = new HashMap<>();
    }

    @Override
    public Cell makeMove(Board board, List<Player> players) {

        //! 1. Check are there any positions where the BOT is wining


        //! 2. Check whether any player has the winning position

        //! 3. If 1 and 2 does not satisfy, then play a random position/near to the last move
        return null;
    }

    Cell checkForWinningPosition(Board board)
    {
        if(rowFrequency.isEmpty() && colFrequency.isEmpty())
        {

        }
        else
        {
            int maxRow = Integer.MIN_VALUE;
            int maxMarks = Integer.MIN_VALUE;
            //! row wise
            for(int i=0;i<board.getSize();i++){
                maxRow = Integer.max(rowFrequency.get(i), maxRow);
            }

            //! col wise
            for(int i=0;i<board.getSize();i++){
                maxRow = Integer.max(rowFrequency.get(i), maxRow);
            }
        }

        return null;

    }

    private void updateTheFrequencyMaps(Cell cell, Board board) {
        updateRowFrequency(cell.getRow());
        updateColFrequency(cell.getColumn());

        if (cell.getRow() == cell.getColumn()) {
            updateLowerDiagonalFrequency(cell);
        }

        if ((cell.getRow() + cell.getColumn()) == board.getSize()) {
            updateUpperDiagonalFrequency(cell);
        }
    }

    private void updateLowerDiagonalFrequency(Cell cell) {

        char symbol = cell.getPlayer().getSymbol();
        if(!lowerDiagonalFrequency.containsKey(symbol))
        {
            lowerDiagonalFrequency.put(symbol, 0);
        }
        //! update
        lowerDiagonalFrequency.put(symbol, lowerDiagonalFrequency.get(symbol)+1);
    }

    private void updateUpperDiagonalFrequency(Cell cell) {

        char symbol = cell.getPlayer().getSymbol();
        if(!upperDiagonalFrequency.containsKey(symbol))
        {
            upperDiagonalFrequency.put(symbol, 0);
        }
        //! update
        upperDiagonalFrequency.put(symbol, upperDiagonalFrequency.get(symbol)+1);
    }

    private void updateColFrequency(int column) {

        if(!colFrequency.containsKey(column))
        {
            colFrequency.put(column, 0);
        }
        //! update
        colFrequency.put(column, colFrequency.get(column)+1);
    }

    private void updateRowFrequency(int row) {

        if(!rowFrequency.containsKey(row))
        {
            rowFrequency.put(row, 0);
        }
        //! update
        rowFrequency.put(row, rowFrequency.get(row)+1);
    }
}
