package examManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

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
		myScores.forEach(s -> {
			if (testCriteria.test(s)) {
				System.out.println(s);
			}
		});
	}
}
