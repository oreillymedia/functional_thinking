

import java.util.List;
import java.util.ArrayList;

// BEGIN counter_demo
class Counter {
    public int varField;

    Counter(int var) {
        varField = var;
    }

    public static Counter makeCounter() {
        return new Counter(0);
    }

    public int execute() {
        return ++varField;
    }
}
// END counter_demo

class AnonCounter {
    public int varField;

    public static AnonCounter makeCounter() {
        final int var = 0;
        return new AnonCounter() {{
            varField = var;
        }};
    }

    public int execute() {
        return ++varField;
    }
}

interface ListerFunc {
    public int call(int arg);
    public int getSum();
}

class Adder implements ListerFunc {
    private int sum = 0;

    public int getSum() {
        return sum;
    }

    Adder() {
        sum = 0;
    }

    public int call(int arg) {
        return sum += arg;
    }
}

class ListApplier {
    public static int apply(List<Integer> list, ListerFunc f) {
        for (int i : list)
            f.call(i);
        return f.getSum();
    }
}

public class CounterDemo {

    public CounterDemo() {
        Counter c1, c2;
        c1 = Counter.makeCounter();
        c1.execute();
        c1.execute();
        c1.execute();

        c2 = Counter.makeCounter();
        System.out.println("c1 = " + c1.execute() + ", c2 = " + c2.execute());

        AnonCounter c3 = AnonCounter.makeCounter();
        System.out.println("c3 (1) = " + c3.execute() + ", c3 (2) = " + c3.execute());

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++)
            list.add(i);

        int sum = ListApplier.apply(list, new Adder());
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        new CounterDemo();
    }
}
