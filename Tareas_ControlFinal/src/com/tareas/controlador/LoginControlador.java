package com.tareas.controlador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import com.controlador.entidades.DatosUsuario;
import com.tareas.modelos.DBDatosUsuario;


public class LoginControlador extends GenericForwardComposer
<Component>{
	
	@Wire
	Textbox textbox_usuario, textbox_clave;
	Button button_ingresar;
	Label Label_mensaje;
	
	String mensaje="";
	
	
	public void onClick$button_ingresar(){
		DatosUsuario datosusuario=null;
		///validacion de datos
		if(textbox_usuario.getValue().isEmpty() || textbox_clave.getValue().isEmpty()){
			mensaje="Usuario y clave son requeridos";
			
		}else{
			//autenticacion
			
		DBDatosUsuario dbdatosusuario = new DBDatosUsuario();
		datosusuario = dbdatosusuario.autenticarUsuario(textbox_usuario.getValue(), textbox_clave.getValue());
	    }	
		if(datosusuario != null){
			Session session = Sessions.getCurrent();
			session.setAttribute("datosusuario", datosusuario);
			Executions.sendRedirect("/PaginaPrincipal.zul");			
		}else{
			mensaje="Usuario y/o clave incorrecta";
		}
	Label_mensaje.setValue(mensaje);
	} 
}

