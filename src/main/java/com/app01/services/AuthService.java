package com.app01.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app01.domain.Cliente;
import com.app01.repositories.ClienteRepository;
import com.app01.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	//@Autowired
	private Random rand = new Random();// biblioteca que gera valores aleatórios
	
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String (vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3); //gera aleatoriamente um numero de 0 à 2
		
		if(opt == 0) { // se o nº gerado acima for 0, gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if(opt == 1) { // gera uma letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else {
			return (char) (rand.nextInt(26) + 97);
		}
	}

}
