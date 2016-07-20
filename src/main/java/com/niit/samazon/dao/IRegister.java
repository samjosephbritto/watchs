package com.niit.samazon.dao;

import java.util.List;

import com.niit.samazon.model.Register;

public interface IRegister {
	public void addRegisteration(Register register);
	public List<Register> getRegisteration();
}
