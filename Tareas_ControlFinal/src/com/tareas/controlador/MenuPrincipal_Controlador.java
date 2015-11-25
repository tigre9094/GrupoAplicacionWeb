package com.tareas.controlador;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.controlador.entidades.DatosUsuario;


public class MenuPrincipal_Controlador extends GenericForwardComposer<Component>{

	//enlazar los componentes de la interfaz
	@Wire
	Label label_usuario;
	Button buttonreportes, buttonpermisos, buttontareas, buttonpersonas,buttongrupos;
	Center centro;
	
	//declarar variables
	DatosUsuario datosusuario=null;
	int roles;
	String tipo="Usuario: ";

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	Session session = Sessions.getCurrent();
	datosusuario = (DatosUsuario) session.getAttribute("datosusuario");
	if(datosusuario!=null){
	String nombrec= tipo + datosusuario.getUsuario().getTipousuario().getDescripcion() +": "+ datosusuario.getUsuario().getPersona().getNombres()
			+" "+datosusuario.getUsuario().getPersona().getApellidos();
		label_usuario.setValue(nombrec);
	}else{	Executions.sendRedirect("login.zul");
	
}
	

	//creamos menu en base al tipo de usuario y el permiso que le demos
	//crearMenu();
	}

	public void onClick$button_cerrarsesion(){
	Session session = Sessions.getCurrent();
	session.invalidate();
	Executions.sendRedirect("login.zul");
	}
		
		
	public void onClick$buttonconsultas(){
		Window win=(Window) Executions.createComponents("Submenues/submenuConsulta.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}
	
	public void onClick$buttonpermisos(){
		Window win=(Window) Executions.createComponents("Submenues/submenuPermisos.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}

	public void onClick$buttonpersonas(){
		Window win=(Window) Executions.createComponents("Submenues/submenuPersonas.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}
	
	public void onClick$buttontareas(){
		Window win=(Window) Executions.createComponents("Submenues/submenuTareas.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}
	
	public void onClick$buttongrupos(){
		Window win=(Window) Executions.createComponents("Submenues/submenuGrupos.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}
	public void onClick$buttonconfiguraciones(){
		Window win=(Window) Executions.createComponents("Submenues/submenuConfiguracion.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}
	public void onClick$buttonreportes(){
		Window win=(Window) Executions.createComponents("Submenues/submenuReporte.zul", null, null );
		win.setAttribute("centro", centro);
		win.setTitle("Opciones");
		win.doModal();		
	}
	public void crearMenu(){
//procedimiento crear menu ocultando los botones sino cuenta con los privilegios
		/*if(roles!=16){
			buttonusuarios.setVisible(false);
			buttonparametros.setVisible(false);
		}
*/
	}

}
