import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Consumer {
    public static List consumer(){
        Logger logger = LoggerFactory.getLogger(Consumer.class.getName());

        String bootstrapServer = "localhost:9092";
        String groupId = "my app";
        String topic = "weather_topic";

        //Create Consumer Properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //Create Consumer
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(properties);

        //Subscribe Consumer to our Topic(s)
        consumer.subscribe(Arrays.asList(topic)); //subscribe to more topics by doing: topic, second_topic, third_topic


        List<String> recordList = new ArrayList<>();
        //Poll for new data
        while(recordList.size()<3){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<String, String> record : records){
                logger.info("Key: " + record.key() + ", Value: "  + record.value());
                logger.info("Partition: " + record.partition() + ", Offset: " + record.offset());
                recordList.add(record.value());
            }
        }
        return recordList;
    }
}
