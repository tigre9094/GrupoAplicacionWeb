package com.tareas.submenu;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Window;

import com.controlador.entidades.Usuario;

public class submenuPermisos extends GenericForwardComposer<Component>{
	//enlace a los componentes de la interfaz
	@Wire
	Button buttonnuevoPermisos, buttonbusquedaPermisos,buttonedicionPermisos;
	Window winPermisos;
	Center centro= null;
	Usuario usuario=null;
	int roles;

    @Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		 centro = (Center)winPermisos.getAttribute("centro");
		 
		/* //sesion para obtener usuario logoneado
		 Session session = Sessions.getCurrent();
			usuario = (Usuario) session.getAttribute("usuario");
			//llamamos al modelo
			DBUsuario rol = new DBUsuario();
			//usamos el void buscar jerarquia con el id de la sesion para conocer que tipo de usuario ingreso al sistema
			roles = rol.buscarjerarquia(usuario.getPersona().getId()+"");
			//creamos el menu en base los privilegios del usuario autenticado
			crearMenu();*/
	}

    
	
	public void crearMenu(){
		if(roles!=16){
		//	buttonnuevoli.setDisabled(true);
			//buttonedicionli.setDisabled(true);
		}

	}

    
	public void onClick$buttonnuevoPermisos(){
   	 if(centro.getFirstChild()!=null){
  	 centro.removeChild(centro.getFirstChild());
  	 }
   	   	Window win=(Window) Executions.createComponents("submenuPermisos/nuevoPermiso.zul", centro, null );
  		win.setTitle("Nuevo Productos");
  		win.setAttribute("op", "1");
  		winPermisos.detach();
   }             
                
   public void onClick$buttonbusquedaPermisos(){
  	if(centro.getFirstChild()!=null){
  	 centro.removeChild(centro.getFirstChild());
  	 }
  		Window win=(Window) Executions.createComponents("Modulo_Control_Productos/BuscarProductos.zul", centro, null );
  		win.setTitle("Busqueda Productos"); 
  		winPermisos.detach();
   }  
	
   public void onClick$buttonedicionPermisos(){
  	if(centro.getFirstChild()!=null){
  	 centro.removeChild(centro.getFirstChild());
  	 }
   		Window win=(Window) Executions.createComponents("Modulo_Control_Productos/ListarProductos.zul", centro, null );  		
  		win.setTitle("Listar Productos");
  		winPermisos.detach();
   }
}

