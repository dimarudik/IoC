package org.example;

import org.junit.jupiter.api.Test;

public class ConstructorAnnotatedOnlyTest {
    @Test
    public void constructorAnnotatedOnly() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.register(ConstructorAnnotatedOnly.class);
        ConstructorAnnotatedOnly constructorAnnotatedOnly = beanFactory.getBean(ConstructorAnnotatedOnly.class);
        constructorAnnotatedOnly.call();
        beanFactory.printBeans();
    }
}
@BublikBean
class ConstructorAnnotatedOnly {
    @BublikInject
    public ConstructorAnnotatedOnly(){
    }
    public void call() {
        System.out.println("MainBean calling call");
    }
}