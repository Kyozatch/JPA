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
public class Person {
	//nom, prénom, son genre, son mail, sa date de naissance et son profil facebook.

    private Long id;
    private String name;
    private String forname;
    private boolean type;
    private String dateOfBirth;
    private List<Person> amis = new ArrayList<Person>();
    private List<Home> maisons = new ArrayList<Home>();
    private Person Ami = this;
    
    
    
    public Person() {

    }

    public Person(String name, String forname, boolean type, String dateOfBirth) {

        this.name = name;
        this.forname = forname;
        this.type= type;
        this.dateOfBirth=dateOfBirth;
        
    }
    
    @OneToMany(mappedBy = "ami", cascade = CascadeType.PERSIST)

    public List<Person> getAmis() {

        return amis;

    }
    @ManyToOne
    public Person getAmi(){
    	return this;
    }
    
    @OneToMany(mappedBy = "habitant", cascade =CascadeType.PERSIST)
    public List<Home> getMaisons(){
    	return maisons;
    }
    
    public void setAmi(Person Ami){
    	this.Ami= Ami;
    }
    
    public void setMaisons(List<Home> maisons){
    	this.maisons=maisons;
    }
    public void setAmis(List<Person> amis) {

        this.amis = amis;
    }
    
    
    @Id
    @GeneratedValue

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }
    
    public String getForname() {

        return forname;

    }

    public void setForname(String forname) {

        this.forname = forname;

    }
    
    public boolean getType() {

        return type;

    }

    public void setType(boolean type) {

        this.type = type;

    }   
    
    public String getDateOfBirth() {

        return dateOfBirth;

    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;

    }   
    


    
    @Override
    public String toString() {

        return "Person [id=" + id + ", dateOfBirth=" + dateOfBirth + ", name=" + name + ", forname=" + forname+", type="+type  + "]";
    }


}