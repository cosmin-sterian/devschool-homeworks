package PizzaStore.Employee;

public interface Employable {

	enum EmployeeType { CUSTOMER_SERVICE, BAKER }

	public void setEmployeeId(int employeeId);
	public int getEmployeeId();

	public void setEmployeeType(EmployeeType employeeType);
	public EmployeeType getEmployeeType();

}
