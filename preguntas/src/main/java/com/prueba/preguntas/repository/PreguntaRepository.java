/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.repository;

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
public class PreguntaRepository {

    @PersistenceContext
    private EntityManager em;

    private static final Log LOG = LogFactory.getLog(PreguntaRepository.class);

    @Transactional
    public String crearPreguntaYRespuesta(String descripcion, int id_categoria,
            String respuesta1, boolean valido1,
            String respuesta2, boolean valido2,
            String respuesta3, boolean valido3,
            String respuesta4, boolean valido4
    ) {
        String retorno = null;
        try {
            em.createNativeQuery("INSERT INTO pregunta (descripcion,id_categoria) VALUES (:descripcion,:id_categoria)").
                    setParameter("descripcion", descripcion).
                    setParameter("id_categoria", id_categoria).
                    executeUpdate();            
            String idPregunta = (String) em.createNativeQuery("SELECT TOP 1 CAST ( id AS VARCHAR ) AS id FROM pregunta ORDER BY id DESC").getSingleResult();
            em.createNativeQuery("INSERT INTO respuesta (descripcion,id_pregunta,valido) VALUES (:descripcion,:id_pregunta,:valido)").
                    setParameter("descripcion", respuesta1).
                    setParameter("id_pregunta", idPregunta).
                    setParameter("valido", valido1).
                    executeUpdate();
            em.createNativeQuery("INSERT INTO respuesta (descripcion,id_pregunta,valido) VALUES (:descripcion,:id_pregunta,:valido)").
                    setParameter("descripcion", respuesta2).
                    setParameter("id_pregunta", idPregunta).
                    setParameter("valido", valido2).
                    executeUpdate();
            em.createNativeQuery("INSERT INTO respuesta (descripcion,id_pregunta,valido) VALUES (:descripcion,:id_pregunta,:valido)").
                    setParameter("descripcion", respuesta3).
                    setParameter("id_pregunta", idPregunta).
                    setParameter("valido", valido3).
                    executeUpdate();
            em.createNativeQuery("INSERT INTO respuesta (descripcion,id_pregunta,valido) VALUES (:descripcion,:id_pregunta,:valido)").
                    setParameter("descripcion", respuesta4).
                    setParameter("id_pregunta", idPregunta).
                    setParameter("valido", valido4).
                    executeUpdate();
        } catch (Exception e) {
            LOG.error("obtenerConfiguracionPorLlave fallo", e);
        }
        return retorno;
    }
}
