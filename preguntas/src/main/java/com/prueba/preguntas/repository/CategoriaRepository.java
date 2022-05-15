/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.repository;

import com.prueba.preguntas.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author crist
 */
@Repository
public class CategoriaRepository {

    @PersistenceContext
    private EntityManager em;
    
    private static final Log LOG = LogFactory.getLog(CategoriaRepository.class);

    @Transactional
    public String crearCategoria(String descripcion, int nivel, int premio) {
        String retorno = null;
        try {
            em.createNativeQuery("INSERT INTO CATEGORIA (descripcion,nivel,premio) VALUES (:descripcion,:nivel,:premio)").
                    setParameter("descripcion", descripcion).
                    setParameter("nivel", nivel).
                    setParameter("premio", premio).                    
                    executeUpdate();
        } catch (Exception e) {
            LOG.error("crearCategoria fallo", e);
        }
        return retorno;
    }
    public List<Categoria> obtenerCategoria() {
        List<Categoria> retorno = new ArrayList<>();
        try {
            retorno = (List<Categoria>) em.createNativeQuery("SELECT CAST(id AS VARCHAR) AS id,descripcion FROM categoria").                    
                    getResultList();
        } catch (Exception e) {
            LOG.error("obtenerCategoria fallo", e);
        }
        return retorno;
    }
}
