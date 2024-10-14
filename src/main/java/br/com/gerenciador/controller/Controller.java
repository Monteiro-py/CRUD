package br.com.gerenciador.controller;

import br.com.gerenciador.model.Objeto;
import br.com.gerenciador.objetoDTO.ObjetoDTO;
import br.com.gerenciador.objetoDTO.Orcamento;
import br.com.gerenciador.service.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class Controller {
    @Autowired
    Repository repositorio;


    @Transactional
    @PostMapping
    public ResponseEntity<ObjetoDTO> cadastro(@RequestBody ObjetoDTO objetoDTO, URI uri){
        Objeto objeto=new Objeto(objetoDTO);
        repositorio.save(objeto);
        return ResponseEntity.created(uri).body(objetoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ObjetoDTO>> obterBancoDeDados(Pageable page) {
        var pages= repositorio.findAllByAtivoTrue(page).map(ObjetoDTO::new);
        //return repositorio.findAll().stream().map(ObjetoDTO::new).toList();
        return ResponseEntity.ok(pages);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
//        repositorio.deleteById(id);
        var objeto=repositorio.getReferenceById(id);
        System.out.println(objeto);
        objeto.exclusaoLogica();
        return ResponseEntity.noContent().build();//notContent não constroi um objeto Response entity, logo precisamos chamr o .build()

    }

    @Transactional
    @PutMapping
    public ResponseEntity<ObjetoDTO> atualizar(@RequestBody ObjetoDTO objetoDTO){
        Objeto objetoPut=repositorio.getReferenceById(objetoDTO.id());
        System.out.println(objetoPut);
        //        Objeto objeto= new Objeto(objetoDTO);
//        objeto.atualizar(objetoDTO);
        objetoPut.atualizar(objetoDTO);
        System.out.println(objetoDTO);
        //repositorio.save(objetoPut);
        return ResponseEntity.ok(new ObjetoDTO(objetoPut));
    }

    @GetMapping("/orcamento")
    public String orcamento(){
        List<Objeto> produtos= repositorio.findAll();
        var lista=produtos.stream().map(n->new Orcamento(n.getProduto(),n.getValor(),n.getData())).toList();
        //System.out.println(lista);
        int count=0;
        for(int i=0;i<lista.size();i++){
            count+=lista.get(i).getValor();
            System.out.println(count);
        }
        String mensagem="O orçamento total de seus produtos é de R$"+count+",00";
        return mensagem;
    }


}
