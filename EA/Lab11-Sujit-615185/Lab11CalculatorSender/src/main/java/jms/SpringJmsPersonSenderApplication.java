package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;


	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJmsPersonSenderApplication.class, args);
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();

		Calculator calculator = new Calculator('+',7);
		String calculatorString = objectMapper.writeValueAsString(calculator);
		System.out.println("Sending a JMS message:" + calculatorString);
		jmsTemplate.convertAndSend("testQueue",calculatorString);

		Calculator calculator1 = new Calculator('+',8);
		String calculator1String = objectMapper.writeValueAsString(calculator1);
		System.out.println("Sending a JMS message:" + calculator1String);
		jmsTemplate.convertAndSend("testQueue",calculator1String);


	}

}
