package com.app01.services;

import org.springframework.mail.SimpleMailMessage;

import com.app01.domain.Cliente;
import com.app01.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}
