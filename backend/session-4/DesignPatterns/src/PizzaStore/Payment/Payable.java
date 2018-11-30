package PizzaStore.Payment;

public interface Payable {

	public float getAvailableSum();
	public boolean pay(float sum);

	boolean insufficientFundsCheck(float sum);

}
