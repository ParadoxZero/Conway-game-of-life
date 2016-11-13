/**
 * Author: Sidhin S Thomas (ParadoxZero)
 * Email : sidhin.thomas@gmail.com
 */

public class Display {
    public static void refresh(boolean [][] matrix){
        System.out.println("----------------------------------------------------------");
        System.out.flush();
        for( int i=0; i<matrix.length; ++i){
               for(int j=0; j< matrix[i].length; ++j){
                   System.out.print('|');
                   System.out.flush();
                   if (matrix[i][j])
                       System.out.print('O');
                   else
                       System.out.print(' ');
                   System.out.flush();
               }
               System.out.println('|');
               System.out.flush();
           }
    }
}
