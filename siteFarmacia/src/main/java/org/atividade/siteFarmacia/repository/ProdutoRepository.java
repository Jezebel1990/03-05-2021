package org.atividade.siteFarmacia.repository;

import java.util.List;

import org.atividade.siteFarmacia.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByCategoriaContainingingIgnoreCase (String categoria);

}
