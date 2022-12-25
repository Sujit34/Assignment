import Classes.AClass;
import Classes.BClass;
import IoC.MyInjector;

public class Main {
    public static void main(String[] args) throws Exception {
        MyInjector myInjector = new MyInjector();
        myInjector.scanForBean();
        System.out.println(myInjector.getBean(AClass.class));
    }
}