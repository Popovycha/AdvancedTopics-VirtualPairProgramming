import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Learning Generics
public class Main {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer(1,"Simon Brown","10 East Street");
		Customer customer2 = new Customer(1,"Jean White","16 North Road");
		Customer customer3 = new Customer(1,"Alison Green","9 South Gardens");

		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
        //When we set up <Customer> as a type of iteration,we don't need to cast anymore (Customer)-line 21
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			Customer nextCustomer = iterator.next();
			//We add (Customer) because it java.alang.object , we need to cast it (Type mismatch).
			System.out.println(nextCustomer.getName());
			//Casting can give a runtime errors there is why Java use Generics


			for (Customer nextCustomers : customers) {
				System.out.println(nextCustomer.getName());
			}
		}
	}

}
