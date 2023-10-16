import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise4 {
	DecimalFormat money = new DecimalFormat ("#0.00");
	Scanner keyboard = new Scanner (System.in);
	final double TAX_RATE = .08;

    public void Run() {
		Pizza order = new Pizza ();

		String firstName;		
		boolean discount = false;
		int pizzaSizeInches;		
		char crustType;			
		double cost;			
		double tax;			
		char choice;			
		String input;			
		String toppings = "Cheese ";
		int numberOfToppings = 0;

		System.out.println("Welcome to Mike and Diane's Pizza");
		System.out.print("Enter your first name:  ");
		firstName = keyboard.nextLine();

		if(isEligableForDiscount(firstName))
			discount= true;


		pizzaSizeInches = getPizzaSizeChoice();
		setPizzaSizeAndPrice(pizzaSizeInches,order);

		//prompt user and get crust choice
		crustType = getCrustType();
		setCrustTypeOnOrder(crustType,order);

		
		List<String> toppingsList= getToppings();


		//set number of toppings and topping list on pizza ordered
		order.setNumToppings (toppingsList.size());
		order.setToppingList(String.join(",",toppingsList));

		//add additional toppings cost to cost of pizza
		order.setCost(1.25*toppingsList.size());

		//display order confirmation
		displayOrderConfirmation(order);

		mightApplyDiscount(discount,order);

		cost = order.getCost();
		System.out.println("The cost of your order is: $" + money.format(cost));

		calculateAndDisplayTax(cost);

		System.out.println("Your order will be ready" +
			" for pickup in 30 minutes.");
	}

	private boolean isEligableForDiscount(String firstName){
		if (firstName.equalsIgnoreCase("Mike") || firstName.equalsIgnoreCase("Dianes"))
			return true;
		return false;

	}

	private int getPizzaSizeChoice(){
		System.out.println("Pizza Size (inches)   Cost");
		System.out.println("        10            $10.99");
		System.out.println("        12            $12.99");
		System.out.println("        14            $14.99");
		System.out.println("        16            $16.99");
		System.out.println("What size pizza would you like?");
		System.out.print("10, 12, 14, or 16 (enter the number only): ");
		return Integer.parseInt(keyboard.nextLine());
	}

	private void setPizzaSizeAndPrice(int pizzaSizeInches, Pizza order){
		if (pizzaSizeInches == 10)
		{
			order.setSize(10);
			order.setCost(-2);
		}
		else if (pizzaSizeInches ==12)
		{
			order.setSize(12);
			order.setCost(0);
		}
		else if (pizzaSizeInches == 14)
		{
			order.setSize(14);
			order.setCost(2);
		}
		else if (pizzaSizeInches == 16)
		{
			order.setSize(16);
			order.setCost(4);
		}
		else
		{
			System.out.print("User input was not one of the choices, so a 12 inch pizza will be made");
			order.setSize(12);
			order.setCost(0);
		}

	}

	private char getCrustType(){
		System.out.println("What type of crust do you want? ");
		System.out.print("(H)Hand-tossed, (T) Thin-crust, or " +
			"(D) Deep-dish (enter H, T, or D): ");
		String input = keyboard.nextLine();
		return input.charAt(0);
	}

	private void setCrustTypeOnOrder(char crustType, Pizza order){
		switch(crustType)
		{
			case 'H':
			case 'h':
				order.setCrust("Hand-Tossed");
				break;
			case 'T':
			case 't':
				order.setCrust("Thin-Crust");
				break;
			case 'D':
			case 'd':
				order.setCrust("Deep Dish");
				break;
			default:
				System.out.print("User's input not one of the choices, so a hand tossed crust will be made");
				order.setCrust("Deep Dish");
		}

	}

	private List<String> getToppings(){
		List<String> toppings = new ArrayList<>();
		
		System.out.println("All pizzas come with cheese.");
		System.out.println("Additional toppings are $1.25 each,"
				+ " choose from");
		System.out.println("Pepperoni, Sausage, Onion, Mushroom");
		if(askForTopping("Pepperoni"))
			toppings.add("Pepperoni");
		if(askForTopping("Sausage"))
			toppings.add("Sausage");
		if(askForTopping("Onion"))
			toppings.add("Onion");
		if(askForTopping("Mushroom"))
			toppings.add("Mushroom");
		return toppings;

	}

	private boolean askForTopping(String topping){
		System.out.printf("Do you want %s?  (Y/N):  ", topping);
		String input = keyboard.nextLine();
		char  choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y')
			return true;
		return false;
	}

	private void displayOrderConfirmation(Pizza order){
		System.out.println();
		System.out.println("Your order is as follows: ");
		System.out.println(order.getSize() + " inch pizza");
		System.out.println(order.getCrust() + " crust");
		System.out.println(order.getToppingList());

	}
	private void mightApplyDiscount(boolean discount, Pizza order){
		if (discount==true)
		{
			System.out.print("User is eligable for a $2.00 discount. ");
			order.setCost(-2);
		}


	}

	private void calculateAndDisplayTax(double cost){
		double tax = cost * TAX_RATE;
		System.out.println("The tax is:  $" + money.format(tax));
		System.out.println("The total due is:  $" + money.format(tax + cost));

	}

}    
