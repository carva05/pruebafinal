/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.preguntas.repository.CategoriaRepository;
import com.prueba.preguntas.util.ExtJSReturn;

/**
 *
 * @author crist
 */
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
                
    @PostMapping(value = "/crear")    
    public @ResponseBody
    Map<String, Object> crear(@RequestParam String descripcion,@RequestParam int nivel, @RequestParam int premio) throws Exception {
        try {
            return ExtJSReturn.mapOK(categoriaRepository.crearCategoria(descripcion,nivel,premio));
        } catch (Exception e) {
            String error = "Error inesperado creando el perfil";
            if (e.getMessage().startsWith("Duplicate entry")) {
                error = "No se pudo adicionar el perfil debido a que el nombre ya se encuentra registrado.";
            }            
            return ExtJSReturn.mapError(error);
        }
    }
    
    @GetMapping("/categorias")
    public @ResponseBody
    Map<String, Object> obtenerCategorias() {
        try {
            return ExtJSReturn.mapOK(categoriaRepository.obtenerCategoria());
        } catch (Exception e) {
            String error = "Error inesperado creando cargando Categorias";
            return ExtJSReturn.mapError(error);
        }
    }
}
