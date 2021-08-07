package com.tesis.v1.domain;

public class Responsables {

    private FaseProyecto idfase;
	private SubGrupo id_sub_grupo;
	private SubGrupo idgrupo;
    private Grupo email;
    
    
    
	public Responsables() {
	
	}
	public Responsables(FaseProyecto idfase, SubGrupo id_sub_grupo, SubGrupo idgrupo, Grupo email) {
		super();
		this.idfase = idfase;
		this.id_sub_grupo = id_sub_grupo;
		this.idgrupo = idgrupo;
		this.email = email;
	}
	public FaseProyecto getIdfase() {
		return idfase;
	}
	public void setIdfase(FaseProyecto idfase) {
		this.idfase = idfase;
	}
	public SubGrupo getId_sub_grupo() {
		return id_sub_grupo;
	}
	public void setId_sub_grupo(SubGrupo id_sub_grupo) {
		this.id_sub_grupo = id_sub_grupo;
	}
	public SubGrupo getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(SubGrupo idgrupo) {
		this.idgrupo = idgrupo;
	}
	public Grupo getEmail() {
		return email;
	}
	public void setEmail(Grupo email) {
		this.email = email;
	}
    

}
