/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.Resource;

import br.senac.sc.Financeiroapi.model.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alunos
 */
@RestController
public class EnderecoResource {
    
    @GetMapping(path = "/enderecos")

    public List<Endereco> Listar2() {
        List<Endereco> enderecos = new ArrayList<>();
        
        enderecos.add(new Endereco(1,"NA", "32", "casa", "P20", "123456789", "Palhoça", "SC"));
        enderecos.add(new Endereco(2,"NA", "15", "AP", "P20", "134679852", "Palhoça", "SC"));
        enderecos.add(new Endereco(3,"NA", "03", "casa", "P20", "167943825", "Palhoça", "SC"));
        return enderecos;
    }
    
}
