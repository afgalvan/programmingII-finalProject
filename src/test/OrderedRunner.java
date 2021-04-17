package test;

import java.util.ArrayList;
import java.util.List;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class OrderedRunner extends BlockJUnit4ClassRunner {

    public OrderedRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        List<FrameworkMethod> sortedMethods = new ArrayList<>(list);
        sortedMethods.sort(
            (method1, method2) -> {
                Order o1 = method1.getAnnotation(Order.class);
                Order o2 = method2.getAnnotation(Order.class);

                if (o1 == null || o2 == null) {
                    return -1;
                }

                return o1.order() - o2.order();
            }
        );
        return sortedMethods;
    }
}
