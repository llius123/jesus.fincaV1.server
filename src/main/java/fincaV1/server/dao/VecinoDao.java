package fincaV1.server.dao;

import java.util.List;

import fincaV1.server.entity.VecinoBean;

public interface VecinoDao {

	public List<VecinoBean> login(String user, String pass);
}
