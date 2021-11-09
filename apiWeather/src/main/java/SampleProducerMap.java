import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;
import java.util.Properties;

public class SampleProducerMap {

    public SampleProducerMap(Map input) {

        System.out.println(input);

        String bootstrapServer = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, MapSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MapSerializer.class.getName());

        //Create Producer
        KafkaProducer<String, Map> producer = new KafkaProducer<String, Map>(properties);

        //Create Producer Record
        ProducerRecord<String, Map> record = new ProducerRecord<String,Map>("weather_topic", input);

        //Send data - asynchronous
        producer.send(record);
        producer.flush(); //flush data
        producer.close(); //flush data and close producer


    }
}
