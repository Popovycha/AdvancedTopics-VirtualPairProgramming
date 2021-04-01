package examManager;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class Main {

	public static boolean isItLowerThan50(Double d) {
		return (d < 50);
	}

	public static void main(String[] args) {

		//Change to Function instead of interface, we use built in.
		ToDoubleFunction<List<Double>> average = myScores -> {

				Double sum = 0d;

				for (Double nextScore : myScores) {
					sum += nextScore;
				}
				return sum / myScores.size();

		};
		//Lambda expression for highest score
		ToDoubleFunction<List<Double>> highestScore = myScores -> {
			double highest = 0d;
			for (Double nextScore : myScores) {
				highest = Math.max(highest, nextScore);
			}
			return highest;

		};
		ExamManager examManager = new ExamManager();
		System.out.println ("The average score is " + examManager.customCalculation(average));
		System.out.println ("The highest score is " + examManager.customCalculation(highestScore));
		System.out.println("The first score is " + examManager.customCalculation(myScores -> myScores.get(0)));
		examManager.PrintScores();
		System.out.println("---");
		//examManager.printSelectedScores(examManager::isItLowerThan50); //ch 17

		examManager.printSelectedScores(Main::isItLowerThan50); //ch 17
//		System.out.println("The total of all scores is: " + examManager.getTotalOfAllScores());
//		System.out.println("---");
//		examManager.doubleAllScores();
//
	List<Double> doubleScores = examManager.doubleAllScores1();
		doubleScores.forEach( System.out::println);//method reference
	}

}
