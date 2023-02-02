import java.util.ArrayList;

public class CustomerCheck
{
	/** The check for a customer or group of customers
	 *  Guaranteed to contain at least one MenuItem and all entries are non-null
	 */
	private ArrayList<MenuItem> check;

	/* Constructor */
	public CustomerCheck(ArrayList<MenuItem> check)
	{
		this.check = check;
	}

	/** Returns the total of all MenuItem prices on the check,
	 *  as described in part (a)
	 */
	public double totalPrices()
	{
		// this method was supposed to be given to us but okay
		double total = 0;
		for (MenuItem item : check)
			total += item.getPrice();
		return total;
	}

	/** Returns true if the restaurants coupon offer can be applied to this check and
	 *  returns false otherwise, as described in part (b) */
	public boolean couponApplies()
	{
		if (totalPrices() < 40)
			return false;
		for (MenuItem item : check)
			if (item.isDailySpecial())
				return false;
		return true;
	}

	/** Calculates the final cost of this check, as described in part (c) */
	public double calculateCheck()
	{
		double originalTotal = totalPrices();
		double total = originalTotal;
		if (couponApplies())
			total -= originalTotal * 0.25;
		int customers = 0;
		for (MenuItem item : check)
			if (item.isEntree()) customers++;
		if (customers >= 6)
			total += originalTotal * 0.20;
		return total;
	}

	// this is actually part (c)
	public boolean hasPremiumEntrees() {
		for (MenuItem item : check)
			if (item.isPremiumEntree())
				return true;
		return false;
	}
}
