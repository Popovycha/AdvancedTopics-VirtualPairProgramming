package examManager;

import java.util.Comparator;

public class DecendingComparator implements Comparator<Double> {
    public int compare (Double x, Double y) {
        int result = 0;
        if (x > y) result = 1;
        if (y < x) result = -1;
        return result;
    }
}
