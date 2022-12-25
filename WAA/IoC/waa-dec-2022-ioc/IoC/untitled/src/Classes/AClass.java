package Classes;

import IoC.MyAutowired;
import IoC.MyBean;

@MyBean
public class AClass {
    @MyAutowired
    private BClass b;

    public AClass(){
        System.out.println("AClass Initialized");
    }

    public void print(){
        System.out.println("Printing from A");
    }
}

