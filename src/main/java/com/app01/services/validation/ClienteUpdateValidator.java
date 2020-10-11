package com.app01.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.app01.domain.Cliente;
import com.app01.dto.ClienteDTO;
import com.app01.repositories.ClienteRepository;
import com.app01.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO>{

	public void initialize(ClienteUpdate ann) {}

	@Autowired
	private ClienteRepository repo;


	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
        // verificando email
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null && aux.getEmail() != objDto.getEmail()) {
			list.add(new FieldMessage("email", "email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}