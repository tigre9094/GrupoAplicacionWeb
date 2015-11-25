package com.tareas.submenu;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Window;

import com.controlador.entidades.DatosUsuario;
import com.controlador.entidades.Usuario;


public class submenuTareas extends GenericForwardComposer<Component>{
	//enlace a los componentes de la interfaz
		@Wire
		Button buttonnuevotareas, buttonbusquedatareas,buttonediciontareas;
		Window wintareas;
		Center centro= null;
		Usuario usuario=null;
		DatosUsuario datosusuario=null;
		int roles;

	    @Override
		public void doAfterCompose(Component comp) throws Exception {
			// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			 centro = (Center)wintareas.getAttribute("centro"); 
			 
			
			
			 Session session = Sessions.getCurrent();
				datosusuario = (DatosUsuario) session.getAttribute("datosusuario");
				roles = datosusuario.getUsuario().getTipousuario().getId();
				crearMenu();
		}

		
	    public void crearMenu(){
			if(roles!=1){
				buttonnuevotareas.setVisible(false);
				buttonediciontareas.setVisible(false);
				//winCategorias.removeChild(buttonnuevocategoria);
				 //winCategorias.removeChild(buttonedicioncategoria);
			}
		}
	    
		public void onClick$buttonnuevotareas(){
	   	 if(centro.getFirstChild()!=null){
	  	 centro.removeChild(centro.getFirstChild());
	  	 }
	   	   	Window win=(Window) Executions.createComponents("Modulo_Control_Categoria/RegistroCategoria.zul", centro, null );
	  		win.setTitle("Nueva Tarea");
	  		wintareas.detach();
	   }             
	                
	   public void onClick$buttonbusquedatareas(){
	  	if(centro.getFirstChild()!=null){
	  	 centro.removeChild(centro.getFirstChild());
	  	 }
	  		Window win=(Window) Executions.createComponents("Modulo_Control_Categoria/BuscarCategoria.zul", centro, null );
	  		win.setTitle("Busqueda Tarea"); 
	  		wintareas.detach();
	   }  
		
	   public void onClick$buttonediciontareas(){
	  	if(centro.getFirstChild()!=null){
	  	 centro.removeChild(centro.getFirstChild());
	  	 }
	   		Window win=(Window) Executions.createComponents("Modulo_Control_Categoria/ListarCategoria.zul", centro, null );  		
	  		win.setTitle("Listar Tareas");
	  		wintareas.detach();
	   }
	}

