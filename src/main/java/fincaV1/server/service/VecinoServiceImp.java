package fincaV1.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.dao.VecinoDao;
import fincaV1.server.dao.VecinoDaoImp;
import fincaV1.server.daogeneric.GenericDaoImp;
import fincaV1.server.entity.VecinoBean;

@Service
public class VecinoServiceImp implements VecinoService {

	@Autowired
	private VecinoDao vecinoDao;

	
	@Transactional
	public List<VecinoBean> login(String user, String pass) {
		return vecinoDao.login(user, pass);
	}

}
