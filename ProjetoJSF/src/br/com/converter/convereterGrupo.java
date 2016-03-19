package br.com.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class convereterGrupo implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		
			if(str.equals("") || str.equals("Selecione um grupo") )
				return null;
			else
				return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
