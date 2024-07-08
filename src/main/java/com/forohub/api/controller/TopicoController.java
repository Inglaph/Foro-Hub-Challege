package com.forohub.api.controller;

import com.forohub.api.topico.DatosRegistroTopico;
import com.forohub.api.topico.Topico;
import com.forohub.api.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico (@RequestBody DatosRegistroTopico datosRegistroTopico) {
        System.out.println(" El request fue exitoso");
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

}

