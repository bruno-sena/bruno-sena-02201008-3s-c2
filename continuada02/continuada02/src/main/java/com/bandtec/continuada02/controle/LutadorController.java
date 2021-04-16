package com.bandtec.continuada02.controle;


import com.bandtec.continuada02.dominio.Lutador;
import com.bandtec.continuada02.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody Lutador novoLutador) {
        novoLutador.setConcentracoesRealizadas(0);
        novoLutador.setVida(100);
        novoLutador.setVivo(true);

        repository.save(novoLutador);
        return ResponseEntity.status(201).build();


    }

    @GetMapping
    public ResponseEntity getLutadores() {
        List<Lutador> lutadores = repository.findAll();

        if (lutadores.isEmpty()) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.ok(lutadores);
        }

    }

    
}

//    @PostMapping ("/golpe")
//    public ResponseEntity postGolpe(@RequestBody int idLutadorBate, int idLutadorApanha){
//        List<Lutador> lutadores = repository.findAll();
//        lu
//    }
//
//    }



