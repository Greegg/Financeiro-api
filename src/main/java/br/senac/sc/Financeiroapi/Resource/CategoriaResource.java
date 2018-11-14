/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.Resource;

import br.senac.sc.Financeiroapi.model.Categoria;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alunos
 */



//POSTAMAN
@RequestMapping("/categorias")
@RestController

public class CategoriaResource {

    
    @GetMapping
    public List<Categoria> Listar() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria(1L, "Transporte"));
        categorias.add(new Categoria(2L, "Alimentação"));
        categorias.add(new Categoria(3L, "Educação"));
        return categorias;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    
    public Categoria salvar(@RequestBody Categoria categoria){
        System.out.println(categoria.getNome());
        
        return categoria;
    }

}
