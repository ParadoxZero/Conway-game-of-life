import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Author: Sidhin S Thomas (ParadoxZero)
 * Email : sidhin.thomas@gmail.com
 */
public class LifeBoard {
    private boolean[][] matrix, transition ;

    public LifeBoard(int i, int j, int max) {
        matrix = new boolean[i][j];
        transition = new boolean[i][j];
        for (boolean[] row: matrix) {
            Arrays.fill(row, Boolean.TRUE);
        }
        for (boolean[] row: transition) {
            Arrays.fill(row, Boolean.TRUE);
        }
        Random rand = new Random();
        while(max-->0){
            int x = rand.nextInt(i) ;
            int y = rand.nextInt(j) ;
            transition[x][y] = matrix[x][y] = false ;
        }
    }

    public void update(){
        for(int i=0; i< matrix.length; ++i){
            for(int j=0; j< matrix[i].length; ++j){
                int count = 0 ;
                try {
                    if (matrix[i][j - 1])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i][j + 1])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i + 1][j - 1])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i - 1][j - 1])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i + 1][j + 1])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i - 1][j + 1])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i+1][j])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if (matrix[i-1][j])
                        count++;
                }catch (ArrayIndexOutOfBoundsException e){}
                if (count < 2){
                    transition[i][j] = false;
                }
                else if(count < 3){
                    transition[i][j] = matrix[i][j];
                }
                else if(count == 3 && !matrix[i][j]){
                    transition[i][j] = true;
                }
                else if(count > 3){
                    transition[i][j] = false;
                }
            }
        }
        for(int i=0; i< matrix.length; ++i){
            for(int j=0; j<matrix[i].length; ++j){
                matrix[i][j] = transition[i][j];
            }
        }
    }

    public boolean[][] getMatrix(){
        return matrix;
    }

}
