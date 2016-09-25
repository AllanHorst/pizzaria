package br.com.sliceitup.vo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "pedido")
public class PedidoVO {

	public static String STATUS_AGUARDANDO = "AGUARDANDO";
	public static String STATUS_MONTANDO = "MONTANDO";
	public static String STATUS_ASSANDO = "ASSANDO";
	public static String STATUS_ENTREGANDO = "ENTREGANDO";
	public static String STATUS_ENTREGUE = "ENTREGUE";
	public static String STATUS_CANCELADO = "CANCELADO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "saida")
	private Calendar saida;

	@Column(name = "data")
	private Calendar data;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "idcliente")
	private ClienteVO cliente;

	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<ItemPedidoVO> listaItens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemPedidoVO> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<ItemPedidoVO> listaItens) {
		this.listaItens = listaItens;
	}

}