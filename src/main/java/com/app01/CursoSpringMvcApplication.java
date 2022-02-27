package com.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app01.services.S3Service;

@SpringBootApplication
public class CursoSpringMvcApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		s3Service.uploadfile("C:\\Users\\fsdfe\\OneDrive\\Pictures\\bitcoin nft.png");
	}	

}
