package org.example;

import org.junit.jupiter.api.Test;

public class FieldAnnotatedConstructorTest {
    @Test
    public void FieldAnnotatedConstructor() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register(FieldAnnotatedWithConstructor.class);
        FieldAnnotatedWithConstructor fieldAnnotatedConstructor = beanFactory.getBean(FieldAnnotatedWithConstructor.class);
        fieldAnnotatedConstructor.call();
        beanFactory.printBeans();
    }
}
@BublikBean
class FieldAnnotatedWithConstructor {
    @BublikInject
    private InnerBean innerBean;
    public FieldAnnotatedWithConstructor(){}
    public FieldAnnotatedWithConstructor(InnerBean innerBean) {
        this.innerBean = innerBean;
    }
    public void call() {
        System.out.println("MainBean calling call");
        innerBean.doWork();
    }
}

