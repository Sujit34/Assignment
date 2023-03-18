package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorMessageListener {
    @Autowired
    Operation operation;

    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String CalculatorAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Calculator calculator = objectMapper.readValue(CalculatorAsString, Calculator.class);
            System.out.println("JMS receiver received message:" + calculator.getOperator()+" "+calculator.getValue());
            if(calculator.getOperator() == '+') {
                operation.add(calculator.getValue());
                System.out.println(operation);
            }
            if(calculator.getOperator() == '-') {
                operation.add(calculator.getValue());
                System.out.println(operation);
            }
            if(calculator.getOperator() == '*') {
                operation.add(calculator.getValue());
                System.out.println(operation);
            }

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + CalculatorAsString+" to a Calculator object");
        }
    }
}
