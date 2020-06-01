package cse.capstonedesign.Capstone;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class CapstoneApplication implements Jackson2ObjectMapperBuilderCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

	@Override
	public void customize(Jackson2ObjectMapperBuilder builder) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTimeSerializer localSerializer = new LocalDateTimeSerializer(formatter);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		CustomOffsetDateTimeSerializer offsetSerializer = new CustomOffsetDateTimeSerializer(formatter2);

		builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss").serializerByType(LocalDateTime.class, localSerializer)
				.serializerByType(OffsetDateTime.class, offsetSerializer);
	}

	public class CustomOffsetDateTimeSerializer extends OffsetDateTimeSerializer {
		public CustomOffsetDateTimeSerializer(DateTimeFormatter formatter) {
			super(OffsetDateTimeSerializer.INSTANCE, false, formatter);
		}
	}
}
