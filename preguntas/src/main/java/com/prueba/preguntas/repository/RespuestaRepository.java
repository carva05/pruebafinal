/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.preguntas.repository;

import com.prueba.preguntas.vo.PreguntaVO;
import com.prueba.preguntas.vo.RespuestaVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;


/**
 *
 * @author crist
 */
@Repository
public class RespuestaRepository {

    @PersistenceContext
    private EntityManager em;

    private static final Log LOG = LogFactory.getLog(RespuestaRepository.class);

    public List<PreguntaVO> obtenerSiguientePregunta(String nivel) {
        List<PreguntaVO> retorno = null;
        try {
            retorno = (List<PreguntaVO>) em.createNativeQuery("SELECT TOP 1 p.descripcion AS descripcionPregunta, "
                    + "	c.premio AS premio,"
                    + "	p.id AS id_pregunta "
                    + "FROM pregunta AS p "
                    + "JOIN categoria AS c ON  c.id = p.id_categoria "
                    + "WHERE c.nivel = :nivel "
                    + "ORDER BY NEWID();").
                    setParameter("nivel", nivel).
                    getSingleResult();
        } catch (Exception e) {
            LOG.error("obtenerSiguientePregunta fallo", e);
        }
        return retorno;
    }

    public List<RespuestaVO> obtenerRespuestasPregunta(String id_pregunta) {
        List<RespuestaVO> retorno = null;
        try {
            retorno = (List<RespuestaVO>) em.createNativeQuery("SELECT id,descripcion,valido FROM respuesta WHERE id_pregunta = :id_pregunta").
                    setParameter("id_pregunta", id_pregunta).
                    getSingleResult();
        } catch (Exception e) {
            LOG.error("obtenerSiguientePregunta fallo", e);
        }
        return retorno;
    }
}
