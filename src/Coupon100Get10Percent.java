
public class Coupon100Get10Percent implements AddOn, Coupon {
	public boolean applies(PurchasedItems items) {
		//if total cost exceeds $100
		if(items.getTotalCost() >= 100)
			return true;
		return false;
	}

	public String getLines() {
		return "Coupon 10%\n(Spend $100 - get 10% off)";
	}
}
