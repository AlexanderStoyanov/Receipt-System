
public class CATaxComputation extends TaxComputation {
	public double computeTax(PurchasedItems items, String date) {
		return (items.getTotalCost() * 0.075); // 7.5% tax for CA
	}

	@Override
	protected boolean taxHoliday(String date) {
		return false;
	}
}
