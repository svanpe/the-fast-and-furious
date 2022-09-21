package be.tobania.fast.and.furious.discount;

import be.tobania.fast.and.furious.discount.connectors.redmarket.RedPrice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@TypeHint(types= {RedPrice.class, BigDecimal.class})
@SpringBootApplication
public class DiscountAPIApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(DiscountAPIApplication.class, args);
	}

}
