package PizzaStore.Employee;

import PizzaStore.PizzaStore;

public class CustomerService implements Employable {

	private PizzaStore subject; // Observer pattern
	private int employeeId;
	private EmployeeType employeeType;

	public CustomerService(int employeeId) {
		this.employeeId = employeeId;
		employeeType = EmployeeType.CUSTOMER_SERVICE;
		subject = PizzaStore.getInstance();
	}


	@Override
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int getEmployeeId() {
		return employeeId;
	}

	@Override
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void update() {
		// TODO
	}
}
