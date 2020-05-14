package org.onlineSolutions.CatalogService.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.onlineSolutions.CatalogService.model.TripPacket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumer {

	@Bean
	public ConsumerFactory<String, TripPacket> consumerFactoryJson(){
		
		Map<String, Object> configs = new HashMap<String, Object>();
		
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "json_id");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(TripPacket.class, false));
	}
	
	@Bean
	public ConsumerFactory<String, String> consumerFactoryString(){
		
		Map<String, Object> configs = new HashMap<String, Object>();
		
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "string_id");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new StringDeserializer());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TripPacket> listenerContainerFactory(){
		
		ConcurrentKafkaListenerContainerFactory<String, TripPacket> listenerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		
		listenerFactory.setConsumerFactory(consumerFactoryJson());
		
		return listenerFactory;
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> listenerString(){
		
		ConcurrentKafkaListenerContainerFactory<String, String> listenerString = new ConcurrentKafkaListenerContainerFactory<>();
		
		listenerString.setConsumerFactory(consumerFactoryString());
		
		return listenerString;
	}
}
