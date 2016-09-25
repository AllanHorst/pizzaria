package br.com.sliceitup.vo;

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
@Table(name = "itempedido")
public class ItemPedidoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "tamanho")
	private Integer tamanho;

	@ManyToOne
	@JoinColumn(name = "idpedido")
	private PedidoVO pedido;

	@OneToMany(mappedBy = "itemPedido", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<SaborItemPedidoVO> listaSabores;

	@Column(name = "quantidade")
	private Integer quantidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PedidoVO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoVO pedido) {
		this.pedido = pedido;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public List<SaborItemPedidoVO> getListaSabores() {
		return listaSabores;
	}

	public void setListaSabores(List<SaborItemPedidoVO> listaSabores) {
		this.listaSabores = listaSabores;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
