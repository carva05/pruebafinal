
package com.prueba.preguntas.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_pregunta")
    private int id_pregunta;
    @Column(name = "valido")
    private boolean valido;

    public Respuesta(String descripcion, int id_pregunta, boolean valido) {
        this.descripcion = descripcion;
        this.id_pregunta = id_pregunta;
        this.valido = valido;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
}
