package com.capgemini.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		String bdUrl = "jdbc:mysql://localhost:3306/lista_produtos?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "cris680516!";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		    Connection conexao = DriverManager.getConnection(bdUrl, usuario, senha);
			if (conexao != null) {
				System.out.println("Conectado no BD!");
			}

			return conexao;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
