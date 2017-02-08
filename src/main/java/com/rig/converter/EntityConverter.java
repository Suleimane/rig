package com.rig.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	private Logger logger = LoggerFactory.getLogger(EntityConverter.class);
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.isEmpty())
			return null;

		try {
			String[] values = string.split("-");
			return manager.find(Class.forName(values[0]),
					Long.valueOf(values[1]));
		} catch (Exception e) {
			logger.error("Erro ao converter String em entidade", e);
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object == null)
			return null;

		try {
			Class<?> classe = object.getClass();
			Long id = (Long) classe.getMethod("getId").invoke(object);

			return classe.getName() + "-" + id;
		} catch (Exception e) {
			logger.error("Erro ao converter entidade em String", e);
			return null;
		}
	}

}
