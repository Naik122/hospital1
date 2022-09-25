package com.example.hospital.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doctors")
public class DoctorEntity {

    private long id;
    private String Name;
    private String Specialist;
    private double Salary;
 
    public DoctorEntity() {
  
    }
 
    public DoctorEntity(String Name, String Specialist, double Salary) {
         this.Name = Name;
         this.Specialist = Specialist;
         this.Salary = Salary;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "Name", nullable = false)
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
 
    @Column(name = "Specialist", nullable = false)
    public String getSpecialist() {
        return Specialist;
    }
    public void setSpecialist(String Specialist) {
        this.Specialist = Specialist;
    }
 
    @Column(name = "Salary", nullable = false)
    public double getSalary() {
        return Salary;
    }
    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", Name=" + Name + ", Specialist=" + Specialist + ", Salary=" + Salary
       + "]";
    }
 
}