package com.tareas.controlador;

import java.util.ArrayList;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.controlador.entidades.TipoUsuario;
import com.controlador.entidades.TipoUsuarios;
import com.controlador.entidades.Usuarios;
import com.controlador.entidades.departamento;
import com.tareas.modelos.BDTipoUsuario;
import com.tareas.modelos.DBUsuarios;



public class PersonaControlador extends GenericForwardComposer<Component>{
	@Wire
	Window winNuevoUsuario;
	Textbox textbox_Usuario,textbox_password,textbox_Nombres,textbox_Apellidos,textbox_Direccion,textbox_Email;
	Intbox textbox_Cedula;
	Button button_Registrar,button_Cancelar;
	Combobox Combobox_TipoUsuario,Combobox_TipoDept;
						
@Override
public void doAfterCompose(Component comp) throws Exception {
	// TODO Auto-generated method stub
	
	// TODO Auto-generated method stub
			super.doAfterCompose(comp);
			DBUsuarios dbu=new DBUsuarios();
			//array list para el combo de tipo usuario
			ArrayList <TipoUsuarios> listatusu = null;
			listatusu=dbu.listarTipousuario();
		
			if(listatusu != null)
			{
				ListModelList<TipoUsuarios> modelo= new ListModelList<TipoUsuarios>(listatusu);
				Combobox_TipoUsuario.setModel(modelo);
			}
			else
			{
				alert("No hay elementos que mostrar");
			}
			
			////Array list para llenar el combo Sucursal///
			ArrayList <departamento> departamento = null;
			departamento=dbu.listarSucursal();
			if(departamento != null)
			{
				ListModelList<departamento> mode= new ListModelList<departamento>(departamento);
				Combobox_TipoDept.setModel(mode);
			}
			else
			{
				alert("No hay elementos que mostrar");
			}
		
	
	
	
	
	super.doAfterCompose(comp);
	//vaciar();
}

public void onCreate$winNuevoUsuario(){
	//CargarTipoUsuarios();
	/*Usuarios u;
	 Session s;
	   s=Sessions.getCurrent();
	   u=(Usuarios) s.getAttribute("Usuario");
	   if(u!=null){
		   if(u.getId_tipousuario()==1){*/
			   //CargarTipoUsuarios();
		   /*}else{
			   Executions.sendRedirect("/MenuPrincipalTV.zul");
		   }
	   }else{
		   Executions.sendRedirect("/MenuPrincipalTV.zul");
	   }*/
}

public void vaciar(){
	textbox_Nombres.setValue("");
	textbox_Apellidos.setValue("");
	textbox_Cedula.setText("");
	textbox_Direccion.setValue("");
	textbox_Email.setValue("");
	textbox_Usuario.setValue("");
	textbox_password.setValue("");
	Combobox_TipoUsuario.setText("");
}

public void CargarTipoUsuarios(){
	BDTipoUsuario dbtu= new BDTipoUsuario();
	ArrayList<TipoUsuarios> lista = dbtu.CargarTipoUsuarios();
	ListModelList<TipoUsuarios> modeloDeDatos= new ListModelList<TipoUsuarios>(lista);
	Combobox_TipoUsuario.setModel(modeloDeDatos);
}



public void onClick$button_Registrar(){
	DBUsuarios dbu=new DBUsuarios();
	if(dbu.validarUsuario(textbox_Cedula.getText(),textbox_Usuario.getValue())){
		alert("Usuario ya existe en es registro");
	}
	else{
		Usuarios us=new Usuarios();
		us.setNombres(textbox_Nombres.getValue());
		us.setIdTipoDepartamento((int) Combobox_TipoDept.getSelectedItem().getValue());
		us.setApellidos(textbox_Apellidos.getValue());
		us.setCedula(textbox_Cedula.getText());
		us.setEmail(textbox_Email.getValue());
		us.setDireccion(textbox_Direccion.getValue());
		us.setAlias(textbox_Usuario.getValue());
		us.setDpasssword(textbox_password.getValue());
		us.setId_tipousuario((int) Combobox_TipoUsuario.getSelectedItem().getValue());
		
		boolean resultado= false;
		resultado=dbu.CrearUsuario(us);
		if(resultado){
			alert("Guardado Exitosamente");
			Executions.sendRedirect("/MenuPrincipalTV.zul");
		}else{
			alert("Error al guardar usuario");
		}
	}
	
}

public void onClick$button_Cancelar(){
	winNuevoUsuario.detach();
}
}
