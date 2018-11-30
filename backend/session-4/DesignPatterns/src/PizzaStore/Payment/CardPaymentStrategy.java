package PizzaStore.Payment;

public class CardPaymentStrategy implements Payable {

	private float availableSum;

	public CardPaymentStrategy(float availableSum) {
		this.availableSum = availableSum;
	}

	@Override
	public float getAvailableSum() {
		return availableSum;
	}

	@Override
	public boolean pay(float sum) {
		float discountedSum = computeDiscountedSum(sum);
		if (insufficientFundsCheck(discountedSum)) {
			System.out.println("Transaction declined, not enough funds on your Card.");
			return false;
		}
		availableSum -= discountedSum;
		System.out.println("Card payment successful, remaining sum: " + availableSum);
		return true;
	}

	@Override
	public boolean insufficientFundsCheck(float sum) {
		return availableSum < sum;
	}

	private float computeDiscountedSum(float sum) {
		return (sum - (sum*20/100));
	}
}
