/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.anterior.interfaces;
import com.spring.netbeans.domain.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ImplUsuario {

    public String save(Usuario obj);

    public String update(Usuario obj);

    public Usuario getLogin(String user,String pass);

    public Usuario getOneUser(String user);

    public List<Usuario> allUsers();
}
