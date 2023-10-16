import java.time.LocalDate;
import java.util.Scanner;

public class Exercise1 {
    private Scanner scanner = new Scanner(System.in);

    public void Run() {
        System.out.println("Vilket år är du född?");        
        int yearBorn = Integer.parseInt(scanner.nextLine());

        int yearCurrent = LocalDate.now().getYear();
        
        if(yearBorn > yearCurrent){
            System.out.println("Du är väl inte född i framtiden?");
        }

        if(yearBorn == yearCurrent){
            System.out.println("Är du född detta år??");
        }

        if(yearBorn < yearCurrent){
            int age = yearCurrent-yearBorn;
            System.out.printf("Ok du är ca %d år\n", age);
        }
    } 
}
