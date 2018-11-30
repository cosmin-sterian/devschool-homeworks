package PizzaStore.Payment;

public class FreePizzaCouponStrategy implements Payable {

	@Override
	public float getAvailableSum() {
		return 0;
	}

	@Override
	public boolean pay(float sum) {
		System.out.println("Enjoy your free pizza!");
		return true;
	}

	@Override
	public boolean insufficientFundsCheck(float sum) {
		return false;
	}
}
