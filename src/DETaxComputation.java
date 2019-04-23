
public class DETaxComputation extends TaxComputation {
	public double computeTax(PurchasedItems items, String date) {
		return 0; //0 tax for DE
	}

	@Override
	protected boolean taxHoliday(String date) {
		return false;
	}
}
