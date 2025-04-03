package com.javanauta.trasacao_api.business.services;

import com.javanauta.trasacao_api.controller.dtos.TransacaoRequestDTO;
import com.javanauta.trasacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TransacaoService {
    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto){

        log.info("iniciado o processamento de gravar transacoes "+ dto);
        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            log.error("data e hora maiores que a data atual");
            throw  new UnprocessableEntity("data e hora maiores que e data e hora atuais");
        }
        if (dto.valor() < 0){
            log.error("valor não pode ser menor do que zero");
            throw new UnprocessableEntity("o valor não pode ser menor que zero");
        }

        listaTransacoes.add(dto);
        log.info("Transacoes adicionadas com sucesso");
    }

    public void limparTransacoes(){
        log.info("Iniciado processamento para deletar transações");
        listaTransacoes.clear();
        log.info("Transacoes deletadas com sucesso");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intevaloBusca){
        log.info("Iniciadas buscas de transações por tempo " + intevaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intevaloBusca);

        log.info("Retorno de Transações com sucesso");
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();

    }
}

