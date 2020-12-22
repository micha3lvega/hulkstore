package co.com.hulk.store.shopping.cart.services.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HulkStoreShoppingCartServicesConfig {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
