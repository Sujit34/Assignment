package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        Account createAcc = new Account(1L, "Sujit Kumar Chanda","create");
        String createAccString = objectMapper.writeValueAsString(createAcc);
        System.out.println("Sending a Kafka message for account create:" + createAccString);
        sender.send("Topic1",createAccString);


        Account deposit = new Account(1L,10000.0,"deposit");
        String depositString = objectMapper.writeValueAsString(deposit);
        System.out.println("Sending a Kafka message for deposit" + depositString);
        sender.send("Topic1",depositString);


        Account withdraw = new Account(1L,500.0,"withdraw");
        String withdrawString = objectMapper.writeValueAsString(withdraw);
        System.out.println("Sending Kafka message for withdraw" + withdrawString);
        sender.send("Topic1",withdrawString);

    }
}
