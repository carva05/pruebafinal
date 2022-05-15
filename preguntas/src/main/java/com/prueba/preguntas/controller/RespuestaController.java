/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.controller;

import com.prueba.preguntas.repository.CategoriaRepository;
import com.prueba.preguntas.repository.RespuestaRepository;
import com.prueba.preguntas.util.ExtJSReturn;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crist
 */
@RestController
@RequestMapping("respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping("/siguientepregunta")
    public @ResponseBody
    Map<String, Object> obtenerSiguientePregunta(@RequestParam String nivel) {
        try {
            return ExtJSReturn.mapOK(respuestaRepository.obtenerSiguientePregunta(nivel));
        } catch (Exception e) {
            String error = "Error inesperado obtenerSiguientePregunta";
            return ExtJSReturn.mapError(error);
        }
    }
    
    @GetMapping("/respuestvalida")
    public @ResponseBody
    Map<String, Object> obtenerRespuestaValida(@RequestParam String id_pregunta) {
        try {
            return ExtJSReturn.mapOK(respuestaRepository.obtenerSiguientePregunta(id_pregunta));
        } catch (Exception e) {
            String error = "Error inesperado obtenerRespuestaValida";
            return ExtJSReturn.mapError(error);
        }
    }

}
