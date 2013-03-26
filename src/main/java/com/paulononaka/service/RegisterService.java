package com.paulononaka.service;

import java.util.List;

import com.paulononaka.model.Register;

public interface RegisterService {

    public List<Register> getList();

    public Register getRegister(Long id);

    public void save(Register Register);

    public void delete(Long id);
}