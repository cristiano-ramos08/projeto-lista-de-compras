package com.capgemini.mbean;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.capgemini.dao.CompraDao;
import com.capgemini.model.Compra;


@ManagedBean
@SessionScoped
public class GerenciadorComprasBean {

	private Compra compra;
	private List<Compra> compras;
	// private static int contador;


	public GerenciadorComprasBean() {
		compras = CompraDao.getCompras();
		compra = new Compra(null, "", "", "media", new BigDecimal(0.0), (byte) 0, new Date());
			 
	}

	public void novaCompra() {
		compra = new Compra(null, "", "", "Média",new BigDecimal(0.0), (byte) 0, new Date());
	}

	public void salvarCompra() {

		if (compra.getId() == null) {
			CompraDao.salvar(compra);
			addMessage("Compra salva!");
		} else {
			CompraDao.atualizar(compra);
			addMessage("Tarefa atualizada!");
		}
		compras = CompraDao.getCompras();

		novaCompra();
	}

	public void apagarCompra(Compra compra) {
		CompraDao.apagar(compra.getId());
		compras = CompraDao.getCompras();
		addMessage("Compra apagada!");
	}

	public void editarCompra(Compra compra) {
		this.compra = compra;

	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
