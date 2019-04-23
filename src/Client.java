import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		boolean done = false;
		
		//config file
		TaxComputation[] tc = {new CATaxComputation(), new DETaxComputation(), new MATaxComputation(), new MDTaxComputation()};
		AddOn[] ao = {new HolidayGreeting(), new Rebate1406(), new Coupon100Get10Percent()};
		
		
		PurchasedItems pi = new PurchasedItems();
		ReceiptFactory rf = null;
		Scanner s = new Scanner(System.in);
		String state = "";
		String date = "";
		while(!done) {
			System.out.println("1 - Start New Receipt\n2 - Add Items\n3 - Display Receipt\n4 - Quick Test");
			System.out.print("Choice: ");
			int choice = s.nextInt();
			switch(choice) {
				case 1:
					System.out.println("\n***START NEW RECEIPT***");
					System.out.print("State code (md, ma, ca, de): ");
					state = s.next().toLowerCase();
					System.out.print("Date (yyyy-mm-dd): ");
					date = s.next().toLowerCase();
					rf = new ReceiptFactory(tc, ao, state, date);
					break;
				case 2:
					System.out.println("\n***ADD NEW ITEM***");
					System.out.print("Item code (1406 for rebate): ");
					String code = s.next();
					System.out.print("Description: ");
					String desc = s.next();
					System.out.print("Price: ");
					String price = s.next();
					pi.addItem(new StoreItem(code, desc, price));
					break;
				case 3:
					System.out.println("\n***DISPLAY RECEIPT***\n");
					rf.getReceipt(pi).prtReceipt();
					s.close();
					done = true;
					break;
				case 4:
					//Quick test option
					pi.addItem(new StoreItem("100", "Carrots", "100"));
					pi.addItem(new StoreItem("200", "Cookies", "55.9"));
					pi.addItem(new StoreItem("1406", "Apples", "10.4"));
					System.out.print("State code (md, ma, ca, de): ");
					state = s.next().toLowerCase();
					rf = new ReceiptFactory(tc, ao, state);
					
					System.out.println("\n***DISPLAY RECEIPT***\n");
					rf.getReceipt(pi).prtReceipt();
					s.close();
					done = true;
					break;
				default:
					System.out.println("\nNo such option!");
					break;
			}
		}
	}

}
