/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.netbeans.interfaces;

import com.spring.netbeans.domain.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface DaoUsuario {

    public void create(Usuario obj);

    public List<Usuario> getAll();

    public Usuario getOne(String user);

    public void delete(String user);

    public void update(Usuario obj);

}
