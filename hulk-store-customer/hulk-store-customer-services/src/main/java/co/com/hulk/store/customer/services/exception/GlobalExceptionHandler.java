package co.com.hulk.store.customer.services.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public String handleFeignStatusException(FeignException e, HttpServletResponse response) {

		try {
			// Armar respuesta
			String standarResponse = e.getMessage();

			// Separar repuesta por ":"
			if (standarResponse.contains("{")) {
				String[] splitResponse = standarResponse.split("\\{");

				response.setContentType("application/json");
				response.setStatus(e.status());
				return "{" + splitResponse[splitResponse.length - 1].replace("]", "");

			}
		} catch (Exception e2) {
			response.setStatus(e.status());
			return e.getMessage();
		}

		
		response.setStatus(e.status());
		return e.getMessage();

	}

}