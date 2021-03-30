package examManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamManager {



	private List<Double> myScores;

	public ExamManager() {
		myScores = new ArrayList<Double>();
		myScores.add(78.3);
		myScores.add(69.2);
		myScores.add(44.7);
		myScores.add(61.6);
		myScores.add(80.2);
		myScores.add(66.9);
		myScores.add(54.1);
	}

	public Double customCalculation(ToDoubleFunction<List<Double>> calculator) {
		return calculator.applyAsDouble(myScores);
	}
	public void PrintScores() {
		//for (Double score: myScores) {
			//System.out.println(score);
		//}

		Comparator<Double> descendingComparator = (x, y) -> {
			int result = 0;
			if (x > y) result = 1;
			if (y < x) result = -1;
			return result;
		};

		myScores.sort(descendingComparator);
		//Lambda can be replaced with method reference
		myScores.forEach(s -> System.out.println(s));
	}

	public void printSelectedScores(Predicate<Double> testCriteria) {
		myScores.stream().filter(testCriteria).forEach(s -> System.out.println(s));
		//Ch16
		//Ch16
		//does the same what three lines of code below
//		myScores.forEach(s -> {
//			if (testCriteria.test(s)) {
//				System.out.println(s);
//			}
//		});
	}

	public double getTotalOfAllScores() {

		Stream<Double> scoreStream = myScores.stream();
		return myScores.stream().reduce(0d, (a,b) -> a+b);
	}

	public void doubleAllScores() {
		myScores.stream().map(d -> d *2).forEach(s -> System.out.println(s));
		//map method change values double and looping them
	}
	public List<Double> doubleAllScores1() {
		return myScores.stream().map(d -> d *2).collect(Collectors.toList());

	}

}
