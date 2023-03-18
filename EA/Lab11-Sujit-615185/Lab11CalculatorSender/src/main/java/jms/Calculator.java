package jms;

public class Calculator {
    private char operator;
    private int value;

    public Calculator(){

    }
    public Calculator(char operator, int value){
        this.operator = operator;
        this.value = value;
    }

    public char getOperator(){
        return operator;
    }
    public void setOperator(char operator){
        this.operator = operator;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
}
