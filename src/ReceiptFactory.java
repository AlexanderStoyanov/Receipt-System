import java.time.LocalDate;

public class ReceiptFactory {
	private String header = "Best Buy";
	private String stateCode;
	private String date;
	
	private TaxComputation[] taxComputationsObjs;
	private AddOn[] addOns;
	
	public ReceiptFactory(TaxComputation[] tc, AddOn[] ao, String state) {
		this.taxComputationsObjs = tc;
		this.addOns = ao;
		this.stateCode = state;
	}
	
	//Overloaded constructor for custom date
	public ReceiptFactory(TaxComputation[] tc, AddOn[] ao, String state, String date) {
		this.taxComputationsObjs = tc;
		this.addOns = ao;
		this.stateCode = state;
		this.date = date;
	}
	
	public Receipt getReceipt(PurchasedItems items) {
		Receipt receipt = new BasicReceipt(items);
		
		//if date is not initialized, use system's date
		if (this.date == null) {
			((BasicReceipt) receipt).setDate(String.valueOf(LocalDate.now()));
		} else {
			((BasicReceipt) receipt).setDate(this.date);
		}
		
		//determine what taxComputation object to use based on the stateCode
		//Assuming that stateObjects are sorted in alphabetical order
		switch(this.stateCode) {
			case "ca":
				((BasicReceipt) receipt).setTaxComputation(this.taxComputationsObjs[0]);
				//Addresses assumed to be in the config file
				this.header += " #101\n1000 Strategy St., CA\n123-456-7890\n";
				break;
			case "de":
				((BasicReceipt) receipt).setTaxComputation(this.taxComputationsObjs[1]);
				this.header += " #101\n691 Null Pointer St., DE\n123-456-7890\n";
				break;
			case "ma":
				((BasicReceipt) receipt).setTaxComputation(this.taxComputationsObjs[2]);
				this.header += " #101\n991 Factory St., MA\n123-456-7890\n";
				break;
			case "md":
				((BasicReceipt) receipt).setTaxComputation(this.taxComputationsObjs[3]);
				this.header += " #101\n143 File Not Found St., MD\n123-456-7890\n";
				break;
			default:
				System.out.println("No such state");
				break;
		}
		((BasicReceipt) receipt).setStoreInfo(this.header);
		
		//Cycle through addOns and see which apply
		if(this.addOns != null) {
			for(AddOn a : this.addOns) {
				if(a.applies(items)) {
					if(a instanceof SecondaryHeading) {
						receipt = new PreDecorator(a, receipt);
					} else {
						receipt = new PostDecorator(a, receipt);
					}
				}
			}
		}
		
		return receipt;
	}
}
