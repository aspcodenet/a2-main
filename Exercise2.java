import java.time.LocalDate;
import java.util.Scanner;

public class Exercise2 {
    private Scanner scanner = new Scanner(System.in);

    public void Run() {
        System.out.print("Skriv in tal 1:");
        int a = Integer.parseInt( System.console().readLine() );
        System.out.print("Skriv in tal 2:");
        int b = Integer.parseInt( System.console().readLine() );
        System.out.print("Skriv in tal 3:");
        int c = Integer.parseInt( System.console().readLine() );

        //Calculate the largest
        int s = 0;
        if(a > b && a > c)
            s = a;
        else if(b > a && b > c)
            s = b;
        else  s = c;
        
        System.out.printf("Minst är:%d\n",s);

    }
}
