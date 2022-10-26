/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.anterior.dao;

import com.spring.anterior.interfaces.ImplUsuario;
import com.spring.netbeans.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Repository
public class Crud implements ImplUsuario {

    Connection conect = null;
    java.sql.Statement st = null;
    Conexion con = new Conexion();
    java.sql.Connection cn = con.conexion();
    Connection connMY = null;

    @Override
    @Transactional
    public String save(Usuario obj) {
        var msg = "";
        try {
            String sql = "INSERT INTO usuario (usuario,pasword,nombres,apellidos,fecha,estado) "
                    + "VALUES (?,?,?,?,?,?)";
            conect = con.Conectar("segundod2022_1");
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setString(1, obj.getUsuario());
            statement.setString(2, obj.getPasword());
            statement.setString(3, obj.getNombres());
            statement.setString(4, obj.getApellidos());
            statement.setDate(5, obj.getFecha());
            statement.setString(6, obj.getEstado());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                msg = "LOS DATOS HAN SIDO GUARDADO CON EXITO!";
            } else {
                msg = "NO SE HAN GUARDADO LOS DATOS!";
            }
        } catch (SQLException ex) {
             msg = "NO SE HAN GUARDADO LOS DATOS!";
            System.out.println("Error " + ex);
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    @Transactional
    public String update(Usuario obj) {
        var msg = "";
        try {
            String sql = "UPDATE  usuario SET pasword=?,nombres=?,apellidos=?"
                    + " WHERE usuario=?";
            conect = con.Conectar("segundod2022_1");
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setString(1, obj.getPasword());
            statement.setString(2, obj.getNombres());
            statement.setString(3, obj.getApellidos());
            statement.setString(4, obj.getUsuario());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                msg = "LOS DATOS HAN SIDO ACTUALIZADOS CON EXITO!";
            } else {
                msg = "NO SE HAN ACTUALIZADOS LOS DATOS!";
            }
        } catch (SQLException ex) {
             msg = "NO SE HAN ACTUALIZADOS LOS DATOS!";
            System.out.println("Error " + ex);
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    @Transactional
    public Usuario getLogin(String user, String pass) {
        Usuario obj = null;
        try {
            cn = con.Conectar("segundod2022_1");
            PreparedStatement leer = cn.prepareStatement("select * from usuario where usuario=? and pasword=?");
            leer.setString(1, user);
            leer.setString(2, pass);
            ResultSet rs = leer.executeQuery();
            var t = 0;
            while (rs.next()) {
                obj = new Usuario(rs.getString("usuario"), rs.getString("pasword"),
                        rs.getString("nombres"), rs.getString("apellidos"),
                        rs.getDate("fecha"), rs.getString("estado"));
                t++;
                if (t > 0) {
                    break;
                }
            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    public Usuario getOneUser(String user) {
        Usuario obj = null;
        try {
            cn = con.Conectar("segundod2022_1");
            PreparedStatement leer = cn.prepareStatement("select * from usuario where usuario=?");
            leer.setString(1, user);
            ResultSet rs = leer.executeQuery();
            var t = 0;
            while (rs.next()) {
                obj = new Usuario(rs.getString("usuario"), rs.getString("pasword"),
                        rs.getString("nombres"), rs.getString("apellidos"),
                        rs.getDate("fecha"), rs.getString("estado"));
                t++;
                if (t > 0) {
                    break;
                }
            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        return obj;
    }

    @Override
    @Transactional
    public List<Usuario> allUsers() {
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            cn = con.Conectar("segundod2022_1");
            Statement leer = cn.createStatement();
            ResultSet rs = leer.executeQuery("select * from usuario order by usuario");

            while (rs.next()) {
                var obj = new Usuario(rs.getString("usuario"), rs.getString("pasword"),
                        rs.getString("nombres"), rs.getString("apellidos"),
                        rs.getDate("fecha"), rs.getString("estado"));
                lista.add(obj);
            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        return lista;
    }

}
