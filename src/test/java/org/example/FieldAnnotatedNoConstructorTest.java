package org.example;

import org.junit.jupiter.api.Test;

public class FieldAnnotatedNoConstructorTest {
    @Test
    public void FieldAnnotatedNoConstructor() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register(FieldAnnotatedNoConstructor.class);
        FieldAnnotatedNoConstructor fieldAnnotatedNoConstructor = beanFactory.getBean(FieldAnnotatedNoConstructor.class);
        fieldAnnotatedNoConstructor.call();
        beanFactory.printBeans();
    }
}

@BublikBean
class FieldAnnotatedNoConstructor {
    @BublikInject
    private InnerBean innerBean;
    public void call() {
        System.out.println("MainBean calling call");
        innerBean.doWork();
    }
}
