package fr.istic.tpjpa.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipement {
	
	private boolean chauffage;
	private boolean equipementElectrique;
	private long consommation;
	private long id;
	private Home maisonEquip;
	
	public Equipement(){
	}
	
	public Equipement(boolean chauffage, boolean equipementElectrique, long consommation ){
		this.chauffage=chauffage;
		this.equipementElectrique=equipementElectrique;
		this.consommation=consommation;
	}
	@ManyToOne
	public Home getMaisonEquip(){
		return maisonEquip;
	}
	
	public void setMaisonEquip(Home maisonEquip){
		this.maisonEquip= maisonEquip;
		
	}
	
	
	
    @Id
    @GeneratedValue

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }	
    public boolean getChauffage(){
    	return chauffage;
    }
    public void setChauffage(boolean chauffage){
    	this.chauffage= chauffage;
    	
    }
    public boolean getEquipementElectrique(){
    	return equipementElectrique;
    }
    public void setEquipementElectrique(boolean equipementElectrique){
    	this.equipementElectrique= equipementElectrique;
    	
    }    
    public long getConsommation(){
    	return consommation;
    }
    public void setConsommation(long consommation){
    	this.consommation= consommation;
    	
    }    
	

}
