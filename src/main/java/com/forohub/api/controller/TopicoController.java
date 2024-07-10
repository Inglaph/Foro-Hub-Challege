package com.forohub.api.controller;

import com.forohub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Metodo para registrar un topico
    @PostMapping
    @Transactional
    public void registrarTopico (@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        System.out.println(" El request fue exitoso");
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    // Metodo para listar todos los topicos
    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }
}

