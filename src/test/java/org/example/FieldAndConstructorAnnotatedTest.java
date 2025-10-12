package org.example;

import org.junit.jupiter.api.Test;

public class FieldAndConstructorAnnotatedTest {
    @Test
    public void fieldAndConstructorAnnotated() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register(FieldAndConstructorAnnotated.class);
        FieldAndConstructorAnnotated fieldAndConstructorAnnotated = beanFactory.getBean(FieldAndConstructorAnnotated.class);
        fieldAndConstructorAnnotated.call();
        beanFactory.printBeans();
    }
}
@BublikBean
class FieldAndConstructorAnnotated {
    @Inject
    private final InnerBean innerBean;
    @Inject
    public FieldAndConstructorAnnotated(InnerBean innerBean){
        this.innerBean = innerBean;
    }
    public void call() {
        System.out.println("MainBean calling call");
        innerBean.doWork();
    }
}

