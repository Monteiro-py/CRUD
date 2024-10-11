package br.com.gerenciador;

import br.com.gerenciador.objetoDTO.ObjetoDTO;
import br.com.gerenciador.service.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class Controller {
    @Autowired
    Repository repositorio;


    @Transactional
    @PostMapping
    public ObjetoDTO cadastro(@RequestBody ObjetoDTO objetoDTO){
        Objeto objeto=new Objeto(objetoDTO);
        repositorio.save(objeto);
        return objetoDTO;
    }

    @GetMapping
    public List<ObjetoDTO> obterBancoDeDados(){
       return repositorio.findAll().stream().map(ObjetoDTO::new).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id){
        repositorio.deleteById(id);
    }

    @Transactional
    @PutMapping
    public ObjetoDTO atualizar(@RequestBody ObjetoDTO objetoDTO){
        Objeto objetoPut=repositorio.getReferenceById(objetoDTO.id());
        System.out.println(objetoPut);
        //        Objeto objeto= new Objeto(objetoDTO);
//        objeto.atualizar(objetoDTO);
        objetoPut.atualizar(objetoDTO);
        System.out.println(objetoDTO);
        //repositorio.save(objetoPut);
        return new ObjetoDTO(objetoPut);
    }

}
