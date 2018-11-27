import PizzaStore.Employee.Employable;
import PizzaStore.PizzaStore;

public class Main {

    public static void main(String[] args) {

    	PizzaStore pizzaStore = PizzaStore.getInstance();
		pizzaStore.addEmployee(Employable.EmployeeType.BAKER);
		Employable customer1 = pizzaStore.addEmployee(Employable.EmployeeType.CUSTOMER_SERVICE);
		//TODO: move Factory to PizzaTemplate(request or pizza) maybe, so I can use "ask for pizza", or define in interface and block baker from asking

    }
}
