package com.didispace.chapter53;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.registry.LocateRegistry;

@EnableCaching
@SpringBootApplication
public class Chapter53Application {

	public static void main(String[] args) throws Exception {
//		LocateRegistry.createRegistry(Integer.valueOf(System.getProperty("rmi.port")));
		SpringApplication.run(Chapter53Application.class, args);
	}

	@RestController
	static class HelloController {

		@Autowired
		private UserRepository userRepository;

		@GetMapping("/create")
		public void create() {
			userRepository.save(new User("AAA", 10));
		}

		@GetMapping("/update")
		public User update() {
			User u1 = userRepository.findByName("AAA");
			u1.setAge(20);
			u1 = userRepository.save(u1);
			return u1;
		}

		@GetMapping("/find")
		public User find() {
			User u1 = userRepository.findByName("AAA");
			System.out.println("查询AAA用户：" + u1.getAge());
			return u1;
		}

	}

}
