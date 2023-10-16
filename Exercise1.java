import java.time.LocalDate;
import java.util.Scanner;

public class Exercise1 {
    private Scanner scanner = new Scanner(System.in);

    public void Run() {
        System.out.println("Vilket år är du född?");        
        int d = scanner.nextInt();
        int d2 = LocalDate.now().getYear();
        if(d > d2){
            System.out.println("Du är väl inte född i framtiden?");
        }
        if(d == d2){
            System.out.println("Är du född detta år??");
        }
        if(d < d2){
            System.out.printf("Ok du är ca %d år\n", d2-d);
        }
    } 
}
