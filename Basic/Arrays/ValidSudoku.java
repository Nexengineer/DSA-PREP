package Arrays;
import java.awt.Point;
import java.util.*;

//[Medium] Valid Sudoku => https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Character>> rowMap = new HashMap<>();
        Map<Integer, List<Character>> coulmnMap = new HashMap<>();
        
        Map<Point, List<Character>> gridMap = new HashMap<>();
        
        int rowCount = board.length;
        int colCount = board[0].length;
        int divider = (int)Math.sqrt(rowCount*colCount);
        
        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                Character value = Character.valueOf(board[i][j]);
                Point checkPoint = new Point((int)i/divider, (int)j/divider);
                if(rowMap.get(i)!=null &&
                   rowMap.get(i).contains(value) &&
                   coulmnMap.get(j)!=null &&
                   coulmnMap.get(j).contains(value) &&
                   gridMap.get(checkPoint)!=null &&
                   gridMap.get(checkPoint).contains(value)){
                    return false;
                }
                
                if(rowMap.get(i) == null){
                    rowMap.put(i, new ArrayList<Character>());
                }
                rowMap.get(i).add(value);
                
                if(coulmnMap.get(j) == null){
                    coulmnMap.put(j, new ArrayList<Character>());
                }
                coulmnMap.get(j).add(value);
                
                if(gridMap.get(checkPoint) == null){
                    gridMap.put(checkPoint, new ArrayList<Character>());
                }
                gridMap.get(checkPoint).add(value);
            }
        }
        
        return true;
    }
}
