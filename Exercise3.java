import java.util.Scanner;

public class Exercise3 {
    private Scanner scanner = new Scanner(System.in);

    public boolean canBuyBeer(int age, char location){
        if(age >= 18 && location == 'K') return true;
        if(age >= 20 && location == 'S') return true;
        return false;
    }

    public void Run() {
        System.out.print("Skriv in ålder:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Skriv in var du är (K = krogen, S = systemet)");
        char location =  scanner.nextLine().charAt(0);

        if(canBuyBeer(age, location))
            System.out.println("Ja");
        else
            System.out.println("Nej");
    }


    public void Run2() {
        System.out.print("Skriv in ålder:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Skriv in var du är (K = krogen, S = systemet)");
        char location =  scanner.nextLine().charAt(0);

        if(isValidInput(age,location))
        {
            if(canBuyBeer(age, location))
                System.out.println("Ja");
            else
                System.out.println("Nej");

        }
    }

    public boolean isValidInput(int age, char location){
        if(age >0 && age < 120 && (location == 'S'  || location == 'K'))
            return true;
        return false;
    }

}
