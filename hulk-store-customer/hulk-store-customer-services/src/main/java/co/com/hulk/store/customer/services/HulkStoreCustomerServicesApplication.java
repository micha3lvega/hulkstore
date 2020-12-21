package co.com.hulk.store.customer.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HulkStoreCustomerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreCustomerServicesApplication.class, args);
	}

}
