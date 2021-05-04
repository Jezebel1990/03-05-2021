package org.atividade.siteFarmacia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.atividade.siteFarmacia.Models.Produto;
import org.atividade.siteFarmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
		
	}
	@GetMapping("/{id}")
	public  ResponseEntity<Produto> GetById(@PathVariable Long id){
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Produto>> GetByCategoria(@PathVariable String categoria){
		return ResponseEntity.ok(repositoty.findAllByCategoriaContainingingIgnoreCase(categoria));
	}
    @PostMapping
    public ResponseEntity<Produto> post (@RequestBody Produto produto){
	return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(produto));
	}
    @PutMapping
    public ResponseEntity<Produto> put (@RequestBody Produto produto){
    	return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(produto));
}
  @DeleteMapping("/{pduto}")  
  public void delete(@PathVariable Long id) {
	  repositoty.deleteById(id);
  }
    
}
