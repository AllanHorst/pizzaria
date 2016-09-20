package br.com.sliceitup.dao;

import br.com.sliceitup.vo.ClienteVO;
import br.edu.unisep.model.dao.DAOGenerico;

public class ClienteDAO extends DAOGenerico<ClienteVO> {

	@Override
	public void salvar(ClienteVO objeto) {
		if (objeto.getId() == null) {
			super.salvar(objeto);
		} else {
			alterar(objeto);
		}
	}
}
