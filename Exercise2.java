import java.util.Scanner;

public class Exercise2 {
    private Scanner scanner = new Scanner(System.in);

    public int getTal(int num){
        System.out.printf("Skriv in tal %d:\n",num);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getSmallest(int tal1,int tal2, int tal3) {
        if(tal1 < tal2 && tal1 < tal3) return tal1;
        if(tal2 < tal3 && tal2 < tal1) return tal2;
        return tal3;
    }

    public void Run() {
        int tal1 = getTal(1);
        int tal2 = getTal(2);
        int tal3 = getTal(3);

        int smallest = getSmallest(tal1,tal2,tal3);
       
        System.out.printf("Minst är:%d\n",smallest);

    }
}
