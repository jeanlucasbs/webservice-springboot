package com.io.github.jeanlucasbs.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.io.github.jeanlucasbs.webservice.entities.Category;
import com.io.github.jeanlucasbs.webservice.entities.Order;
import com.io.github.jeanlucasbs.webservice.entities.OrderItem;
import com.io.github.jeanlucasbs.webservice.entities.Product;
import com.io.github.jeanlucasbs.webservice.entities.User;
import com.io.github.jeanlucasbs.webservice.entities.enums.OrderStatus;
import com.io.github.jeanlucasbs.webservice.repositories.CategoryRepository;
import com.io.github.jeanlucasbs.webservice.repositories.OrderItemRepository;
import com.io.github.jeanlucasbs.webservice.repositories.OrderRepository;
import com.io.github.jeanlucasbs.webservice.repositories.ProductRepository;
import com.io.github.jeanlucasbs.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Jean", "jean@gmail.com", "99999999", "123456");
		User u2 = new User(null, "Maria", "maria@gmail.com", "11111111", "654123");
		
		Order o1 = new Order(null, Instant.parse("2023-07-22T19:11:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-07-23T19:11:00Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-07-24T19:11:00Z"), OrderStatus.WAITING_PAYMENT, u1);
				
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Lorem ipsum dolor sit amet, consectetur.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Lorem ipsum dolor sit amet, consectetur.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Lorem ipsum dolor sit amet, consectetur.", 1200.0, "");
		Product p5 = new Product(null, "Rais for Dummies", "Lorem ipsum dolor sit amet, consectetur.", 100.99, "");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1, p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		}

}
