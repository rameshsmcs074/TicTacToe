package LLD3.TicTacToeDesign.strategies.WinningStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategies implements WinningStrategies{

    Map<Integer, Map<Character, Integer>> frequencyMaps;

    public RowWinningStrategies(){
        frequencyMaps = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();

        if(!frequencyMaps.containsKey(row))
        {
            frequencyMaps.put(row, new HashMap<>());
        }

        Map<Character, Integer> rowMap = frequencyMaps.get(row);

        if(!rowMap.containsKey(move.getPlayer().getSymbol()))
        {
            rowMap.put(symbol, 0);
        }

        //! update the row
        rowMap.put(symbol, rowMap.get(symbol)+1);

        if(rowMap.get(symbol)==(board.getSize())){
            System.out.println("Winning via Row"+ row);
            return true;
        }

        return  false;
    }
}
