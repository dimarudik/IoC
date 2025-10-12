package org.example;

import org.junit.jupiter.api.Test;

public class ConstructorAnnotatedFieldTest {
    @Test
    public void constructorAnnotatedField() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register(ConstructorAnnotatedField.class);
        ConstructorAnnotatedField constructorAnnotatedField = beanFactory.getBean(ConstructorAnnotatedField.class);
        constructorAnnotatedField.call();
        beanFactory.printBeans();
    }
}
@BublikBean
class ConstructorAnnotatedField {
    private final InnerBean innerBean;
    @BublikInject
    public ConstructorAnnotatedField(InnerBean innerBean){
        this.innerBean = innerBean;
    }
    public void call() {
        System.out.println("MainBean calling call");
        innerBean.doWork();
    }
}
