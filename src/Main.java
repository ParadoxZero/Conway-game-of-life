import java.util.Scanner;

/**
 * Author: Sidhin S Thomas (ParadoxZero)
 * Email : sidhin.thomas@gmail.com
 */
public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter matrix size number(m,n):");
        int a = reader.nextInt(), b = reader.nextInt(), c = reader.nextInt();
        LifeBoard board = new LifeBoard(a,b,c);
        while(true){
            Display.refresh(board.getMatrix());
            board.update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
    }

}
