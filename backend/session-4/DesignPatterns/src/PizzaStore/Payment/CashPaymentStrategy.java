package PizzaStore.Payment;

public class CashPaymentStrategy implements Payable {

	private float availableSum;

	public CashPaymentStrategy(float availableSum) {
		this.availableSum = availableSum;
	}

	@Override
	public float getAvailableSum() {
		return availableSum;
	}

	@Override
	public boolean pay(float sum) {
		if (insufficientFundsCheck(sum)) {
			System.out.println("Not enough money in your wallet!");
			return false;
		}
		availableSum -= sum;
		System.out.println("Payment using Cash was successful! Remaining sum: " + availableSum);
		return true;
	}

	@Override
	public boolean insufficientFundsCheck(float sum) {
		return availableSum < sum;
	}
}
