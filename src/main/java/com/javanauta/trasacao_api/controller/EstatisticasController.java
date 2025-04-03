package com.javanauta.trasacao_api.controller;
import com.javanauta.trasacao_api.business.services.EstatisticasService;
import com.javanauta.trasacao_api.controller.dtos.EstasticasResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticasService estatisticasService;
    @GetMapping
    @Operation(description = "Endpoint responsavel por buscar estastisticas de transacoes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na busca de estatisticas de transações"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })

    public ResponseEntity<EstasticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca",required = false, defaultValue = "60") Integer intervaloBusca){
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloBusca));
    }
}
