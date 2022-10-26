package com.spring.netbeans.prueba;

import com.spring.anterior.dao.Crud;
import com.spring.netbeans.dao.DaoUsuarioRepository;
import com.spring.netbeans.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class Application {

    //DaoUsuarioRepository crud;
    Crud crud1 = new Crud();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listar() {
        return crud1.allUsers();
    }

    @PostMapping(value = "/ingreso", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String ingreso(@RequestBody Usuario obj) {
       return crud1.save(obj);
    }

    @PostMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String actualizar(@RequestBody Usuario obj) {
        return crud1.update(obj);
    }

    @GetMapping(path = "/getLoginn/{usuario}/{pass}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getLoginn(@PathVariable String usuario, @PathVariable String pass) {
        return crud1.getLogin(usuario, pass);
    }

    @GetMapping(path = "/getOne/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getOneUser(@PathVariable String usuario) {
        return crud1.getOneUser(usuario);
    }

    /*
    @GetMapping(value = "/saludo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String saludo(@RequestParam(value = "name", defaultValue = "Hola") String name) {
        return "Netbeans " + name;
    }

    @GetMapping(path = "/insert/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String insert(@PathVariable String name) {
        return "Netbeans " + name;
    }

    @GetMapping(path = "/resta/{n1}/{n2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int resta(@PathVariable int n1, @PathVariable int n2) {
        return (n1 - n2);
    }

    @GetMapping  /// mediante url
    public int suma(@RequestParam(value = "n1") int n1, @RequestParam(value = "n2") int n2) {
        return (n1 + n2);
    }

    @GetMapping(path = "/objeto/{ced}/{nom}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona objeto(@PathVariable String ced, @PathVariable String nom, @PathVariable Integer edad) {
        return (new Persona(ced, nom, edad));
    }

    @GetMapping(path = "/lista/{ced}/{nom}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> lista(@PathVariable String ced, @PathVariable String nom, @PathVariable Integer edad) {
        List<Persona> lista = new ArrayList<Persona>();
        for (int i = 0; i < 5; i++) {
            lista.add(new Persona(ced, nom, edad));
        }
        return lista;
    }

    @GetMapping(value = "/listaObj", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> listaObj(@RequestBody Persona obj) {
        List<Persona> lista = new ArrayList<Persona>();
        for (int i = 0; i < 5; i++) {
            lista.add(obj);
        }
        return lista;
    }
     */
    @GetMapping(value = "/listaObj1", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void listaObj1(@RequestBody Persona obj) {
        List<Persona> lista = new ArrayList<Persona>();
        for (int i = 0; i < 5; i++) {
            lista.add(obj);
        }

    }
}

class Persona {

    private String cedula;
    private String nombre;
    private Integer edad;

    public Persona(String cedula, String nombre, Integer edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
