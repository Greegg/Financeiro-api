/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.Resource;

import br.senac.sc.Financeiroapi.model.Categoria;
import br.senac.sc.Financeiroapi.model.Endereco;
import br.senac.sc.Financeiroapi.model.Lancamento;
import br.senac.sc.Financeiroapi.model.Pessoa;
import br.senac.sc.Financeiroapi.model.TipoLancamento;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alunos
 */

@RestController
public class PessoaResource {
    
    @GetMapping(path = "/pessoas")

    public List<Pessoa> Listar2() {
        List<Pessoa> pessoas = new ArrayList<>();
        
        
        Endereco end1 = new Endereco(1,"NA", "32", "casa", "P20", "123456789", "Palhoça", "SC");
        Endereco end2 = new Endereco(2,"NA", "15", "AP", "P20", "134679852", "Palhoça", "SC");
        Endereco end3 = new Endereco(3,"NA", "03", "casa", "P20", "167943825", "Palhoça", "SC");
                
        pessoas.add(new Pessoa(1,"gregório", true, end1));
        pessoas.add(new Pessoa(2, "Maria", true, end2));
        pessoas.add(new Pessoa(3, "João", true, end3));
        
        
        return pessoas;
    }
    
}
