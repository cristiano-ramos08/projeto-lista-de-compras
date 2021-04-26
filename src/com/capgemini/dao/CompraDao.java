package com.capgemini.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.factory.ConexaoFactory;
import com.capgemini.model.Compra;

public class CompraDao {

	public static void salvar(Compra compra) {

		String sql = "INSERT INTO compra (nome, descricao, prioridade, preco, quantidade, data_limite) VALUES (?,?,?,?,?,?)";

		try(
				Connection conexao = ConexaoFactory.getConnection(); 
				PreparedStatement statement = conexao.prepareStatement(sql)
		) {
			
			
			
			statement.setString(1, compra.getNome());
			statement.setString(2, compra.getDescricao());
			statement.setString(3, compra.getPrioridade());
			statement.setBigDecimal(4, compra.getPreco());
			statement.setByte(5, compra.getQuantidade());
			statement.setDate(6, new Date(compra.getDataLimite().getTime()));

			int linhasInseridas = statement.executeUpdate();
			if (linhasInseridas > 0) {
				System.out.println("tarefa inserida no BD!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

		public static List<Compra> getCompras(){
		String sql = "SELECT * FROM compra";

		try (
				Connection conexao = ConexaoFactory.getConnection();
				Statement statement = conexao.createStatement();
				ResultSet result = statement.executeQuery(sql);
		){		

			List<Compra> compras = new ArrayList<>();

			while (result.next()) {
				int id = result.getInt(1);
				String titulo = result.getString(2);
				String descricao = result.getString(3);
				String prioridade = result.getString(4);
				double preco = result.getDouble(5);
				int quantidade = result.getInt(6);
				java.util.Date dataLimite = new java.util.Date(result.getDate(7).getTime());
				compras.add(new Compra(id, titulo, descricao, prioridade, new BigDecimal(preco), (byte)quantidade, dataLimite));
			}

			return compras;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void apagar(Integer id) {

		String sql = "DELETE FROM compra WHERE id=?";

		try (Connection conexao = ConexaoFactory.getConnection();
				PreparedStatement statement = conexao.prepareStatement(sql);) {

			statement.setInt(1, id.intValue());

			int linhasApagadas = statement.executeUpdate();
			if (linhasApagadas > 0) {
				System.out.println("compra apagada do BD!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void atualizar(Compra compra) {

		String sql = "UPDATE compra SET nome=?, descricao=?, prioridade=?, preco=?, quantidade=?, data_limite=? WHERE id=?";

		try (Connection conexao = ConexaoFactory.getConnection();
				PreparedStatement statement = conexao.prepareStatement(sql);) {

			statement.setString(1, compra.getNome());
			statement.setString(2, compra.getDescricao());
			statement.setString(3, compra.getPrioridade());
			statement.setBigDecimal(4, compra.getPreco());
			statement.setByte(5, compra.getQuantidade());
			statement.setDate(6, new Date(compra.getDataLimite().getTime()));
			statement.setInt(7, compra.getId().intValue());

			int linhasAtualizadas = statement.executeUpdate();
			if (linhasAtualizadas > 0) {
				System.out.println("compra atualizada no BD!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
