/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author crist
 */
public class ExtJSReturn {
        public static Map<String, Object> mapOK(List datos) {
            Map<String, Object> modelMap;
        if (datos == null) {
            modelMap = new HashMap(2);
            modelMap.put("success", true);
            modelMap.put("total", 0);
        } else {
            modelMap = new HashMap(2);
            modelMap.put("success", true);
            modelMap.put("data", datos);
        }
        return modelMap;
    }

    public static Map<String, Object> mapOK(long total, List datos) {
        Map<String, Object> modelMap;
        modelMap = new HashMap(3);
        modelMap.put("success", true);
        modelMap.put("total", total);
        modelMap.put("data", datos);
        return modelMap;
    }

    public static Map<String, Object> mapOK() {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("success", true);
        modelMap.put("total", 0);
        return modelMap;
    }

    public static Map<String, Object> mapError(String msg) {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("success", false);
        modelMap.put("message", msg);
        return modelMap;
    }
    
    
    public static Map<String, Object> mapError(String msg,int codError) {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("success", false);
        modelMap.put("message", msg);
        modelMap.put("metaData", codError);
        return modelMap;
    }
    

    public static Map<String, Object> mapError(String msg, List datos) {
        Map<String, Object> modelMap;
        if (datos == null) {
            modelMap = new HashMap(3);
            modelMap.put("success", false);
            modelMap.put("message", msg);
        } else {
            modelMap = new HashMap(4);
            modelMap.put("success", false);
            modelMap.put("message", msg);
            modelMap.put("data", datos);
        }
        return modelMap;
    }
    
    public static Map<String, Object> mapOK(Object obj) {
        Map<String, Object> modelMap = new HashMap(2);
        modelMap.put("success", true);
        modelMap.put("data", obj);
        return modelMap;
    }
    
}
