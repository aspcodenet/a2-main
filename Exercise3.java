import java.time.LocalDate;
import java.util.Scanner;

public class Exercise3 {
    private Scanner scanner = new Scanner(System.in);

    public void Run() {
        System.out.print("Skriv in ålder:");
        int age = Integer.parseInt( System.console().readLine() );
        System.out.print("Skriv in var du är (K = krogen, S = systemet)");
        char location =  System.console().readLine().charAt(0);

        if(location == 'K' || location == 'S')
        {
            if( age >0 && age < 120)
            {
                if(age >=18 && location == 'K')
                    System.out.println("Ja");
                else if(age >=20 && location == 'S')
                    System.out.println("Ja");
                else 
                    System.out.println("Nej");
            }
        }
    }
}
