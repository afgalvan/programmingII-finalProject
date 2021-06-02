package test;

import java.util.Comparator;

import org.junit.After;
import org.junit.runners.model.FrameworkMethod;

public class SortByAnnotation implements Comparator<FrameworkMethod> {

    @Override
    public int compare(FrameworkMethod method1, FrameworkMethod method2) {
        Order order1 = method1.getAnnotation(Order.class);
        Order order2 = method2.getAnnotation(Order.class);
        After after1 = method1.getAnnotation(After.class);
        After after2 = method2.getAnnotation(After.class);

        if (order1 == null || order2 == null) {
            return after1 != null ? -1 : 1;
        }

        return order1.value() - order2.value();
    }
}
