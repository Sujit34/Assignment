package Classes;

import IoC.MyAutowired;
import IoC.MyBean;

@MyBean
public class BClass {
    BClass(){
        System.out.println("BClass Initialized");
    }

    public void print(){
        System.out.println("Printing from B");
    }
}
