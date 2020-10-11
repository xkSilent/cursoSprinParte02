package com.app01.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.app01.domain.Cliente;
import com.app01.dto.ClienteDTO;
import com.app01.dto.ClienteNewDTO;
import com.app01.repositories.ClienteRepository;
import com.app01.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO>{
	
	public void initialize(ClienteUpdate ann) {}
	
	@Autowired
	private ClienteRepository repo;
	
<<<<<<< HEAD
	@Autowired
	private HttpServletRequest request;
=======
>>>>>>> 67cd766... Validação customizada: email não repetido na atualização de cliente

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
<<<<<<< HEAD
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null && !Integer.valueOf(aux.getId()).equals(uriId)) {
=======
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null && aux.getEmail() != objDto.getEmail()) {
>>>>>>> 67cd766... Validação customizada: email não repetido na atualização de cliente
			list.add(new FieldMessage("email", "email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
