
public abstract class Decorator implements Receipt {
	private Receipt trailer;
	
	public Decorator(Receipt r) {
		this.trailer = r;
	}
	
	protected void callTrailer() {
		trailer.prtReceipt();
	}
	
	public abstract void prtReceipt();
}
