
public class BasicReceipt implements Receipt {
	private String storeInfo;
	
	private PurchasedItems items;
	private String date;
	private TaxComputation tc;
	private double totalSale; //no tax
	private double amountDue; //with tax
	
	public BasicReceipt(PurchasedItems items) {
		this.items = items;
	}
	
	public void setTaxComputation(TaxComputation tc) {
		this.tc = tc;
	}
	
	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void prtReceipt() {
		System.out.println(this.storeInfo);
		System.out.println(this.date);
		System.out.println(this.items.toString());
		this.totalSale = this.items.getTotalCost();
		System.out.println("\nTotal sale: $" + totalSale);
		System.out.println("Tax: $" + tc.computeTax(items, date));
		this.amountDue = this.totalSale + tc.computeTax(items, date);
		System.out.println("Amount due: $" + (double) Math.round(amountDue*100)/100 + "\n");
	}
}
