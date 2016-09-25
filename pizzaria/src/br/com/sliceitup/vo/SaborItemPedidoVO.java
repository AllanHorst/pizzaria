package br.com.sliceitup.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "saboresitempedido")
public class SaborItemPedidoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idsabor")
	private SaborVO sabor;

	@ManyToOne
	@JoinColumn(name = "iditempedido")
	private ItemPedidoVO itemPedido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SaborVO getSabor() {
		return sabor;
	}

	public void setSabor(SaborVO sabor) {
		this.sabor = sabor;
	}

	public ItemPedidoVO getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedidoVO itemPedido) {
		this.itemPedido = itemPedido;
	}

}
