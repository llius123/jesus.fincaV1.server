package fincaV1.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.dao.IncidenciaDao;
import fincaV1.server.entity.IncidenciaBean;

@Service
public class IncidenciaServiceImp implements IncidenciaService {

	@Autowired
	private IncidenciaDao oIncidenciaDao;
	
	@Transactional
	public List<IncidenciaBean> testApi() {
		return oIncidenciaDao.testApi();
	}

}
