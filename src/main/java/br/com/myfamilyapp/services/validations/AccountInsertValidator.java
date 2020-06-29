package br.com.myfamilyapp.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.myfamilyapp.dto.AccountDTO;
import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.repositories.AccountRepository;
import br.com.myfamilyapp.resources.exceptions.FieldMessage;

public class AccountInsertValidator implements ConstraintValidator<AccountInsert, AccountDTO> {

	@Autowired
	private AccountRepository repo;
	
	@Override
	public void initialize(AccountInsert ann) {
	}

	@Override
	public boolean isValid(AccountDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		Account aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}