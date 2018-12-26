package fincaV1.server.service;

import java.util.List;

import fincaV1.server.entity.VecinoBean;

public interface VecinoService {

	public List<VecinoBean> login(String user, String pass);
	
}
