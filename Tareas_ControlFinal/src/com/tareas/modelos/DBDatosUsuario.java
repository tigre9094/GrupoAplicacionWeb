package com.tareas.modelos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controlador.entidades.DatosUsuario;
import com.controlador.entidades.Persona;
import com.controlador.entidades.TipoUsuario;
import com.controlador.entidades.Usuario;
import com.tareas.controlesSIstema.Encriptacion;


public class DBDatosUsuario {
	public String EncriptarPassword(String dpassword){
		Encriptacion e=new Encriptacion("Encriptar");
		String passwordEncriptado=e.encrypt(dpassword);
		return passwordEncriptado;
	}
	
	public DatosUsuario autenticarUsuario(String user, String pass){		
		DatosUsuario datosusuario= null;	
		Usuario usuario= null;
		Persona persona=null;
		TipoUsuario tipousuario=null;
		DBManager dbm= new DBManager();
		Connection con = dbm.getConection();
		if(con==null){
			System.out.println("Conexion es null");
			return datosusuario;
	}		
		java.sql.Statement sentencia;
		ResultSet resultados= null;
		String passwordenc=pass;
				//EncriptarPassword(pass);
		String query="select * from datosusuario as du, personas as per, usuario as usu, tipousuario as tip"
		+ " where du.id_usuario=usu.id_usuario and usu.id_persona=per.id_persona and usu.id_tipousuario=tip.id_tipousuario and "
		+ " du.alias ='" + user + "' and"
		+ " du.dpassword = '" + passwordenc + "'";		
		System.out.println(query);		
		try {
			sentencia= con.createStatement();
			resultados = sentencia.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Error en ejecucion de sentencia");
			e.printStackTrace();
		}
		try {
			while(resultados.next()){
				datosusuario = new DatosUsuario();
				usuario= new Usuario();
				persona= new Persona();
				tipousuario= new TipoUsuario();
				persona.setId(resultados.getInt("id_persona"));
				persona.setNombres(resultados.getString("nombres"));
				persona.setApellidos(resultados.getString("apellidos"));
				persona.setCedula(resultados.getString("cedula"));
				usuario.setId(resultados.getInt("id_usuario"));
				
				tipousuario.setId(resultados.getInt("id_tipousuario"));
				tipousuario.setDescripcion(resultados.getString("descripcion"));
				usuario.setTipousuario(tipousuario);
				
				usuario.setPersona(persona);
				datosusuario.setAlias(resultados.getString("alias"));
				datosusuario.setClave(resultados.getString("dpassword"));
				datosusuario.setUsuario(usuario);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return datosusuario;
	}
}
	
	