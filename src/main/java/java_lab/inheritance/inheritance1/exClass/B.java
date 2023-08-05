package java_lab.inheritance.inheritance1.exClass;

import java_lab.inheritance.inheritance1.AInterface;

import static java_lab.inheritance.inheritance1.AInterface.NAME;

public class B implements AInterface {
    @Override
    public void say() {
        System.out.println("B");
    }

//    public void setA(String name) {
//        this.NAME = name;
//    }
}
