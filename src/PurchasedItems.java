import java.util.ArrayList;

public class PurchasedItems {
	private ArrayList<StoreItem> items;
	
	public PurchasedItems() {
		this.items = new ArrayList<StoreItem>();
	}
	
	public void addItem(StoreItem item) {
		this.items.add(item);
	}
	
	public double getTotalCost() {
		double total = 0;
		for (StoreItem i : this.items) {
			total += Double.valueOf(i.getItemPrice());
		}
		return total;
	}
	
	public boolean containsItem(String itemCode) {
		for (StoreItem i : this.items) {
			if (i.getItemCode().equals(itemCode))
				return true;
		}
		return false;
	}
	
	public String toString() {
		String s = "";
		for (StoreItem i : this.items) {
			s += "\n" + i.getItemDescription() + " $" + i.getItemPrice();
		}
		return s;
	}
}
