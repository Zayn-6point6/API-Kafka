import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SampleProducerString {

    public SampleProducerString(String input) {

        System.out.println("\nSending to Kafka:");

        String bootstrapServer = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Create Producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //Create Producer Record
        ProducerRecord<String, String> record = new ProducerRecord<String,String>("weather_topic", input);

        //Send data - asynchronous
        producer.send(record);
        producer.flush(); //flush data
        producer.close(); //flush data and close producer


    }
}
