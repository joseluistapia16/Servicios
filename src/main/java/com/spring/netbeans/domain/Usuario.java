/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.netbeans.domain;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Usuario {

    private String usuario;
    private String pasword;
    private String nombres;
    private String apellidos;
    private Date fecha;
    private String estado;

    public Usuario() {

    }

    public Usuario(String usuario, String password, String nombres, String apellidos, Date fecha, String estado) {
        this.usuario = usuario;
        this.pasword = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String password) {
        this.pasword = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
