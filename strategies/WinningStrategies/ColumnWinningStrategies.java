package LLD3.TicTacToeDesign.strategies.WinningStrategies;

import LLD3.TicTacToeDesign.models.Board;
import LLD3.TicTacToeDesign.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategies implements WinningStrategies{

    Map<Integer, Map<Character, Integer>> frequencyMaps;

    public ColumnWinningStrategies(){
        frequencyMaps = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();

        if(!frequencyMaps.containsKey(col))
        {
            frequencyMaps.put(col, new HashMap<>());
        }

        Map<Character, Integer> colMap = frequencyMaps.get(col);
        if(!colMap.containsKey(symbol))
        {
            colMap.put(symbol, 0);
        }

        //! update the frequency
        colMap.put(symbol, colMap.get(symbol)+1);
        System.out.println("Col frequency "+colMap.get(symbol));
        System.out.println("Board size"+ board.getSize());
        if(colMap.get(symbol)==(board.getSize()))
        {
            System.out.println("Winning via Column"+ col);
            return true;
        }

        return false;
    }
}
