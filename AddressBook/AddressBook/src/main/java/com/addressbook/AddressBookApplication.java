package com.addressbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(
				"------------------------------------------------------------------------------------------------");
		System.out.println(
				"-----------------------------------Application Started-----------------------------------------");
		System.out.println(
				"------------------------------------------------------------------------------------------------");
	}

}
