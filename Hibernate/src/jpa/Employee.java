/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import enums.Role;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rixter
 */
@Entity
@Table
public class Employee implements Serializable {
   
    private static final long serialVersionUID = 1L;
   
    
    // Columns
    @Id
    @GeneratedValue
    private Long id;
    @Column(name ="role_id")
    private Role role;
    @Column(name ="name")
    private String name;
    @Column(name ="login")
    private String login;
    @Column(name ="e_mail")
    private String e_mail;
    @Column(name ="password")
    private String password;
    
    
    //Relations
    @ManyToOne
    @JoinColumn(name="divs" , referencedColumnName="id" , insertable=true , updatable=true)
    private Division divs;
    
    @OneToMany
    private List<Report> reports;
    
    // Setters and Getters
    public List<Report> getReport() {
        return reports;
    }

    public void setReport(List<Report> report) {
        this.reports = report;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Division getDivs() {
        return divs;
    }

    public void setDivs(Division divs) {
        this.divs = divs;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    // Implemented methods
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ id=" + id + " ]";
    }
    
}
