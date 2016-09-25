package br.com.sliceitup.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.sliceitup.vo.ItemPedidoVO;
import br.com.sliceitup.vo.PedidoVO;
import br.com.sliceitup.vo.SaborItemPedidoVO;
import br.edu.unisep.hibernate.HibernateSessionFactory;
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

	@Override
	public List<PedidoVO> listar(Class<PedidoVO> classe) {
		Session session = HibernateSessionFactory.getSession();

		Criteria crit = session.createCriteria(classe);
		crit.setResultTransformer(crit.DISTINCT_ROOT_ENTITY);
		List<PedidoVO> lista = crit.list();

		for (PedidoVO pedidoVO : lista) {
			List<ItemPedidoVO> listaItens = new ArrayList<>();
			for (ItemPedidoVO item : pedidoVO.getListaItens()) {
				item.setPedido(null);
				List<SaborItemPedidoVO> listaSabores = new ArrayList<>();
				for (SaborItemPedidoVO sabor : item.getListaSabores()) {
					sabor.setItemPedido(null);
					listaSabores.add(sabor);
				}
				item.setListaSabores(listaSabores);
				listaItens.add(item);
			}
			pedidoVO.setListaItens(listaItens);
		}

		session.close();
		return lista;
	}

}
