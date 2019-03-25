package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.repository.buyer.BuyerRepository;
import com.example.demo.ebook.repository.publisher.PublisherRepository;
import com.example.demo.ebook.service.buyer.BuyerService;
import com.example.demo.ebook.service.publisher.PublisherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomEBookApplicationTests {

	@Autowired
	ApplicationContext context;
	//@Test
	public void saveBuyer() {
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
	//@Test
	public void savePublisher() {
		PublisherRepository repository = context.getBean(PublisherRepository.class);
//		BuyerService service = context.getBean(BuyerService.class);
		Publisher publisher = new Publisher();
		publisher.setEmail("test@test.com");
		publisher.setLoginId("set");
		publisher.setName("john");
		publisher.setPassword("pass");
//		service.registerBuyer(buyer);
		repository.save(publisher);
	}
	
	@Test
	public void validatePublisher() {
		PublisherService service = context.getBean(PublisherService.class);
		String login="sh4yansh@gmail.com";
		String pass="123456";
		Publisher publisher = service.validatePublisher(login, pass);
		System.out.println(publisher);
	}
	
	//@Test
	public void validatePublisherRepo() {
		PublisherRepository repo = context.getBean(PublisherRepository.class);
		String login="sh4yansh@gmail.com";
		String pass="pass";
		List<Publisher> list = repo.findByLoginId(login);
		Publisher publisher = list.get(0);
		System.out.println(publisher);
	}

}
