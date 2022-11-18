package com.tesis.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "public")
public class Usuario {

    //private Integer  idusuario;
    // ID ES EMAIL
    private String email;

    private String nombre;

    private String password;

    private String token;

    private String activo;
    
    private String documento;

    @Column(name = "documento", nullable = false)
    public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	// lista de grupos donde puede estar el usuario
    private List<Grupo> grupos = new ArrayList<Grupo>(0);

    public Usuario() {
        super();
    }

    public Usuario(//Integer idusuario, 
            String email,
            String nombre,
            String password,
            String token,
            String activo,
            List<Grupo> grupos) {
        super();
        //this.idusuario = idusuario;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.token = token;
        this.activo = activo;
        this.grupos = grupos;
    }
    public Usuario(//Integer idusuario, 
            String email,
            String nombre,
            String password,
            String token,
            String activo,
            String documento,
            List<Grupo> grupos) {
        super();
        //this.idusuario = idusuario;
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.token = token;
        this.activo = activo;
        this.grupos = grupos;
        this.documento = documento;
    }
    //----------------

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    //----------------
    /*@Column(name = "idusuario", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}*/
    @Id
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "token", nullable = false)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

}
