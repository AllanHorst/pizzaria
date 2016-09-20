package br.com.sliceitup.dao;

import br.com.sliceitup.vo.PedidoVO;
import br.edu.unisep.model.dao.DAOGenerico;

public class PedidoDAO extends DAOGenerico<PedidoVO> {

	@Override
	public void salvar(PedidoVO objeto) {
		if (objeto.getId() == null) {
			super.salvar(objeto);
		} else {
			alterar(objeto);
		}
	}

}
