
public class StoreItem {
	private String itemCode;
	private String itemDescription;
	private String itemPrice;
	
	public StoreItem(String code, String description, String price) {
		this.itemCode = code;
		this.itemDescription = description;
		this.itemPrice = price;
	}

	public String getItemCode() {
		return itemCode;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
}
