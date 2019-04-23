
public abstract class TaxComputation {
	public abstract double computeTax(PurchasedItems items, String date);
	protected abstract boolean taxHoliday(String date);
}
