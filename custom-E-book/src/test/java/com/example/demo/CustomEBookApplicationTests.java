package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.repository.buyer.BuyerRepository;
import com.example.demo.ebook.service.buyer.BuyerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomEBookApplicationTests {

	@Autowired
	ApplicationContext context;
	@Test
	public void saveProduct() {
		BuyerRepository repository = context.getBean(BuyerRepository.class);
		BuyerService service = context.getBean(BuyerService.class);
		Buyer buyer = new Buyer();
		buyer.setEmail("test@test.com");
		buyer.setLoginId("set");
		buyer.setName("john");
		buyer.setPassword("pass");
		service.registerBuyer(buyer);
		//repository.save(buyer);
	}

}
