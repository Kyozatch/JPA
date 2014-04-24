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

public class Home {
	//Une  maison est définie par une adresse, une superficie, une adresse IP

    private Long id;

    private String adresse;
    private long superficie;
    private String adresseIP;
    private Person habitant;
    private List<Equipement> equipements = new ArrayList<Equipement>();

    public Home(){

    }


    public Home(String adresse, String adresseIP, int superficie) {

        this.adresse = adresse;
        this.adresseIP=adresseIP;
        this.superficie= superficie;
    }
    
    @OneToMany(mappedBy = "maisonEquip", cascade = CascadeType.PERSIST)
    public List<Equipement> getEquipements(){
    	return equipements;
    }
    
    @ManyToOne
    public Person gethabitant(){
    	return habitant;
    }
    
    public void setEquipements(List<Equipement> equipements){
    	this.equipements=equipements;
    	
    }
    
    public void setHabitant(Person habitant){
    	this.habitant=habitant;
    }

    @Id

    @GeneratedValue

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }
    

    public String getadresse() {

        return adresse;

    }

    public void setadresse(String adresse) {

        this.adresse = adresse;

    }
    public String getadresseIP() {

        return adresseIP;

    }

    public void setAdresseIP(String adresseIP) {

        this.adresseIP = adresseIP;

    } 
    public long superficie() {

        return superficie;

    }

    public void setsuperficie(long superficie) {

        this.superficie = superficie;

    }  
    
    
    
/*
    @ManyToOne

    public Department getDepartment() {

        return department;

    }

    public void setDepartment(Department department) {

        this.department = department;

    }
    */

    @Override

    public String toString() {

        return "Home [id=" + id + ", adresse=" + adresse + ", adresseIP=" + adresseIP + ", superficie=" + superficie + "]";

    }

}
