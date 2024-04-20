package com.invoice.invoice;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.List;
import org.springframework.context.annotation.Bean;

import com.invoice.invoice.models.Item;
import com.invoice.invoice.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

  @Bean
  List<Item> itemsInvoice() {
    Product product1 = new Product("Laptop", 2000.0);
    Product product2 = new Product("Keyboard", 300.0);
    Product product3 = new Product("Mouse", 200.0);

    return List.of(
      new Item(product1, 2),
      new Item(product2, 2),
      new Item(product3, 2)
    );
  }
}
