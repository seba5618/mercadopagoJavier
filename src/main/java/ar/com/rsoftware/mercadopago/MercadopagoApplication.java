package ar.com.rsoftware.mercadopago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import com.mercadopago.MercadoPago;

@SpringBootApplication
public class MercadopagoApplication {

	public static void main(String[] args) throws  Exception{
		SpringApplication.run(MercadopagoApplication.class, args);
	}


}
