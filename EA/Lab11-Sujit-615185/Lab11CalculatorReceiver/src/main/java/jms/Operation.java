package jms;

import org.springframework.stereotype.Component;

@Component
public class Operation {
    public int result =0;
    public void add(int x){
        result=result+x;
    }
    public void subtract(int x){
        result=result-x;
    }
    public void multiplication(int x){
        result=result*x;
    }

    @Override
    public String toString() {
        return "Output is : " + result;
    }
}
