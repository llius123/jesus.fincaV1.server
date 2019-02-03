package fincaV1.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.dao.FacturaProveedorDaoImp;
import fincaV1.server.daogeneric.GenericDaoImp;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.entity.TipofacturaBean;

@Service
public class GraficoService {

	@Autowired
	GenericDaoImp genericDaoImp;
	@Autowired
	FacturaProveedorDaoImp facturaProveedorDaoImp;
	
	@Transactional
	public ArrayList<ArrayList<String>> graficoCobrado() {
		
		List cobradoSi = facturaProveedorDaoImp.facturaCountCobrado("s");
		List cobradoNo = facturaProveedorDaoImp.facturaCountCobrado("n");
		ArrayList<String> cobradoSiResult = new ArrayList<String>();
		cobradoSiResult.add("Si");
		cobradoSiResult.add(cobradoSi.get(0).toString());
		
		ArrayList<String> cobradoNoResult = new ArrayList<String>();
		cobradoNoResult.add("No");
		cobradoNoResult.add(cobradoNo.get(0).toString());
		
		ArrayList<ArrayList<String>> reStrings = new ArrayList<ArrayList<String>>();
		reStrings.add(cobradoSiResult);
		reStrings.add(cobradoNoResult);
		
		
		return reStrings;
	}
	
	@Transactional
	public ArrayList<ArrayList<String>> graficoTipofactura() {
		List<TipofacturaBean> listaTipofactura = (List<TipofacturaBean>) genericDaoImp.getAll(TipofacturaBean.class);
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < listaTipofactura.size(); i++) {
			ArrayList<String> resSimple = new ArrayList<String>();
			
			String countTipoFactura = facturaProveedorDaoImp.facturaCountTipofactura(listaTipofactura.get(i).getId()).get(0).toString();
			resSimple.add(listaTipofactura.get(i).getDescripcion());
			resSimple.add(countTipoFactura);
			result.add(resSimple);
		}
		return result;
	}
}
