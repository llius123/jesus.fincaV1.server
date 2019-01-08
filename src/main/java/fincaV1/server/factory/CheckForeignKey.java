package fincaV1.server.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fincaV1.server.daogeneric.GenericDaoImp;
import fincaV1.server.entity.PoblacionBean;
import fincaV1.server.entity.ProvinciaBean;
import fincaV1.server.exception.NotExistForeignKey;
import fincaV1.server.servicegeneric.GenericServiceImp;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class CheckForeignKey {

	@Autowired
	GenericServiceImp genericServiceImp;

	public<T> void checkForeignKey(HashMap<T, Integer> datos) {
		for(Map.Entry<T, Integer> o: datos.entrySet()) {
				if (genericServiceImp.get(o.getKey().getClass(), o.getValue()) == null) throw new NotExistForeignKey("No existe la columna: " + o.getKey().getClass() + " , con el id: " + o.getValue());
			}
	}

}
