package test;

import java.util.Comparator;
import org.junit.runners.model.FrameworkMethod;

public class SortByAnnotation implements Comparator<FrameworkMethod> {

    @Override
    public int compare(FrameworkMethod method1, FrameworkMethod method2) {
        Order order1 = method1.getAnnotation(Order.class);
        Order order2 = method2.getAnnotation(Order.class);

        if (order1 == null || order2 == null) {
            return -1;
        }

        return order1.order() - order2.order();
    }
}
