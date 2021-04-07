import java.util.ArrayList;
import java.util.List;

//Avoiding DeadLocks
public class CustomersList {

	private List<Customer> customers = new ArrayList<Customer>();

	public void addToList(Customer customer) {
		synchronized (this) {

			while (customers.size() > 100) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			customers.add(customer);
			notifyAll(); //notify all next next that is ready to resume
			//notify(); //will tell random one of those
		}
	}

	public Customer getFromList() {
		synchronized (this) {
			while (customers.size() ==0) {
				try {
					wait(); //holds a next thread until present thread processing
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			notifyAll();
			return customers.remove(0);
		}
	}
}

