package com.niit.samazon.service;

import java.util.List;

import com.niit.samazon.model.Register;

public interface IRegisterService {

		public void addRegistration(Register registerBean);
		public List<Register> getRegisteration();
}
