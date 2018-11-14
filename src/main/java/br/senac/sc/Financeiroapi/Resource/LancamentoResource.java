/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sc.Financeiroapi.Resource;

import br.senac.sc.Financeiroapi.model.Categoria;
import br.senac.sc.Financeiroapi.model.Endereco;
import br.senac.sc.Financeiroapi.model.Lancamento;
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
public class LancamentoResource {

    @GetMapping(path = "/lancamentos")

    public List<Lancamento> Listar2() {
        LocalDate localDate = LocalDate.of(2018, Month.OCTOBER, 30);
        LocalDate localDate2 = LocalDate.of(2018, 10, 30);
        
        
        
        List<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(new Lancamento(1, "0", localDate, localDate2, 0, "done", TipoLancamento.DESPESA, new Categoria(2L, "2")));
        lancamentos.add(new Lancamento(2, "1", localDate, localDate2, 0, "done", TipoLancamento.DESPESA, new Categoria(2L, "2")));
        lancamentos.add(new Lancamento(3, "2", localDate, localDate2, 0, "done", TipoLancamento.DESPESA, new Categoria(2L, "2")));
        
        return lancamentos;
    }

}
