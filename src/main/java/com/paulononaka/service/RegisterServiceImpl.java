package com.paulononaka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paulononaka.dao.RegisterDAO;
import com.paulononaka.model.Register;

@Component(value="registerService")
public class RegisterServiceImpl implements RegisterService {

	private RegisterDAO registerDAO;

	@Autowired
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	@Override
	public List<Register> getList() {
		return registerDAO.findAll();
	}

	@Override
	public Register getRegister(Long id) {
		return registerDAO.findById(id);
	}

	@Override
	public void save(Register register) {
		registerDAO.save(register);
	}
	
	@Override
	public void delete(Long id) {
		registerDAO.remove(id);
	}

}