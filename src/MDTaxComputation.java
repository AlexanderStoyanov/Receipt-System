
public class MDTaxComputation extends TaxComputation {
	public double computeTax(PurchasedItems items, String date) {
		return items.getTotalCost() * 0.06;
	}

	@Override
	protected boolean taxHoliday(String date) {
		if(date.equals("2018-08-13") || date.equals("2018-08-14"))
			return true;
		return false;
	}
}
