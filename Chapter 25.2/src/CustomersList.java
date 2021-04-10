import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Avoiding DeadLocks
public class CustomersList {

	private List<Customer> customers = new ArrayList<Customer>();
	private Lock customersLock = new ReentrantLock();
	private Condition customersAvaliable = customers.newCondition();
	private Condition listHasSpace = customers.newCondition();

	public void addToList(Customer customer) {


		customersLock.lock();
			while (customers.size() > 100) {
				try {
					listHasSpace.await();//Any thread called "AddToList" with no room in the list,
					//will wait for this condition for the list to have some space;
					//wait();//doesnt work with locks, works with conditions
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			customers.add(customer);
			customersAvaliable.signalAll();//
			//notifyAll(); //notify all next next that is ready to resume
			//notify(); //will tell random one of those
		customersLock.unlock();
	}

	public Customer getFromList() {
		customersLock.lock();//locks
		try {
			while (customers.size() == 0) {
				try {
					customersAvaliable.await();
					//wait(); //holds a next thread until present thread processing
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//notifyAll();
			listHasSpace.signalAll();//send signal to threads that there is time to try processing again
			return customers.remove(0);
		}
		finally {
			customersLock.unlock(); //we put on finally block to run after return statement
		}
	}
}

