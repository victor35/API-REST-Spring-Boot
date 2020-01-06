package com.victormarques.cursomc.service;

import org.springframework.mail.SimpleMailMessage;

import com.victormarques.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
