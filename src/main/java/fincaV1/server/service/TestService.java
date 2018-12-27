package fincaV1.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.dao.GenericDao;
import fincaV1.server.dao.TestDao;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	@Transactional
	public <T> T getAll(final Class<T> type) {
		return testDao.getall(type);
	}
	
	@Transactional
	public <T> T get(final Class<T> type, final Long id){
		return testDao.get(type,id);
	}
}
