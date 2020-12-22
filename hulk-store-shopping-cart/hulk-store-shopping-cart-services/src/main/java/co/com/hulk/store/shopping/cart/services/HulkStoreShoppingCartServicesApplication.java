package co.com.hulk.store.shopping.cart.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HulkStoreShoppingCartServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreShoppingCartServicesApplication.class, args);
	}

}
