public class StringWorker <T,U> {

    private T o1;
    private U o2;

    public StringWorker(T o1, U o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public String toString() {
        return "StringWorker{" +
                "o1='" + o1 + '\'' +
                ", o2='" + o2 + '\'' +
                '}';
    }

    public T get01() {
        return o1;
    }

    public static <A, B> String getString(A o1,B o2) {
        return "StringWorker{" +
                "o1='" + o1 + '\'' +
                ", o2='" + o2 + '\'' +
                '}';
    }

    public static <A> String getString2(A o1,A o2) {
        return "StringWorker{" +
                "o1='" + o1 + '\'' +
                ", o2='" + o2 + '\'' +
                '}';
    }
}
