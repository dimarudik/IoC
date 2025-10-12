package org.example;

import org.junit.jupiter.api.Test;

public class FieldAnnotatedDefaultConstructorTest {
    @Test
    public void FieldAnnotatedDefaultConstructor() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register(FieldAnnotatedDefaultConstructor.class);
        FieldAnnotatedDefaultConstructor fieldAnnotatedDefaultConstructor = beanFactory.getBean(FieldAnnotatedDefaultConstructor.class);
        fieldAnnotatedDefaultConstructor.call();
        beanFactory.printBeans();
    }
}

@BublikBean
class FieldAnnotatedDefaultConstructor {
    @Inject
    private InnerBean innerBean;
    public FieldAnnotatedDefaultConstructor(){}
    public void call() {
        System.out.println("MainBean calling call");
        innerBean.doWork();
    }
}
