package br.com.generation.lojaDeGames.controller;

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

import br.com.generation.lojaDeGames.model.Produto;
import br.com.generation.lojaDeGames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class ProdutoController {
	
   @Autowired
   private ProdutoRepository repository;
   
   
   @GetMapping
   public ResponseEntity<List<Produto>> findAllProduto(){
        return ResponseEntity.ok(repository.findAll());		
   }
  
  
  @GetMapping("/{id}") 
  public ResponseEntity<Produto> findByIDProduto(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
  }
  
  
  @GetMapping("/descricao/{descricao}")
  public ResponseEntity<Produto> findByDescricaoTitulo(@PathVariable String descricao ){
          return ResponseEntity.ok(repository.findOneByDescricaoContainingIgnoreCase(descricao));
  }

  

  @PostMapping
  public ResponseEntity<Produto> postProduto(@RequestBody Produto produto){
          return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
  }
  
  
  @PutMapping
  public ResponseEntity<Produto> putProduto(@RequestBody Produto produto){
          return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
  }


  @DeleteMapping("/{id}")
  public void deleteProduto(@PathVariable long id){
         repository.deleteById(id);

  } 
	
	

}
