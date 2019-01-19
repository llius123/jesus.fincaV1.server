package fincaV1.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.dao.IncidenciaDaoImp;

@Service
public class IncidenciaServiceImp implements IncidenciaService {
	
	@Autowired
	IncidenciaDaoImp incidenciaDaoImp;

	@Transactional
	public List<Integer> incidenciascount() {
		return incidenciaDaoImp.incidenciacount();
	}

}
