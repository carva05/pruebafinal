/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.controller;

import com.prueba.preguntas.repository.CategoriaRepository;
import com.prueba.preguntas.repository.PreguntaRepository;
import com.prueba.preguntas.util.ExtJSReturn;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crist
 */
@RestController
@RequestMapping("pregunta")
public class PreguntaController {

    @Autowired
    private PreguntaRepository preguntaRepository;
    
    @PostMapping(value = "/crear")    
    public @ResponseBody
    Map<String, Object> crear(@RequestParam String descripcion,@RequestParam int id_categoria,
            @RequestParam String respuesta1,@RequestParam boolean valido1,
            @RequestParam String respuesta2,@RequestParam boolean valido2,
            @RequestParam String respuesta3,@RequestParam boolean valido3,
            @RequestParam String respuesta4,@RequestParam boolean valido4
            ) throws Exception {
        try {
            return ExtJSReturn.mapOK(preguntaRepository.crearPreguntaYRespuesta(descripcion, id_categoria, 
                    respuesta1, valido1,
                    respuesta2, valido2,
                    respuesta3, valido3,
                    respuesta4, valido4));
        } catch (Exception e) {
            String error = "Error inesperado creando la pregunta";
            return ExtJSReturn.mapError(error);
        }
    }
}
