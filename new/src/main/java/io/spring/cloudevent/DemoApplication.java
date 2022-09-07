package io.spring.cloudevent;

import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
	    SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Function<Message<String>, Message<String>> hello() {
		return message -> {
			System.out.println(new PrettyPrintingMap<String, Object>((Map<String, Object>)message.getHeaders()));
			
			String data = message.getPayload();
			return CloudEventMessageBuilder
				.withData(String.format("Headers: %s\nPayload: %s", new PrettyPrintingMap<String, Object>((Map<String, Object>)message.getHeaders()), data))
				.setId("123456")
				.setSource(URI.create("https://spring.cloudevenets.sample")).build();
		};
	}
	
	public class PrettyPrintingMap<K, V> {
		private Map<K, V> map;

		public PrettyPrintingMap(Map<K, V> map) {
				this.map = map;
		}

		public String toString() {
				StringBuilder sb = new StringBuilder();
				Iterator<Entry<K, V>> iter = map.entrySet().iterator();
				while (iter.hasNext()) {
						Entry<K, V> entry = iter.next();
						sb.append(entry.getKey());
						sb.append('=').append('"');
						sb.append(entry.getValue());
						sb.append('"');
						if (iter.hasNext()) {
								sb.append(',').append(' ');
						}
				}
				return sb.toString();
		}
	}
}
