/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import enums.Act_Type;
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
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    // Columns
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "bug_id")
    private Long bug_id;
    @Column(name = "act_type")
    private Act_Type type;
    @Column(name ="description")
    private String description;
    
    
    // Relations
    @OneToMany
    private List<Activity> acts;
    
    @ManyToOne
    @JoinColumn(name="emps",referencedColumnName="id" , insertable=true , updatable=true)
    private Employee emps;
    
    // Setters and Getters
    
    public Employee getEmps() {
        return emps;
    }

    public void setEmps(Employee emps) {
        this.emps = emps;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBug_id() {
        return bug_id;
    }

    public void setBug_id(Long bug_id) {
        this.bug_id = bug_id;
    }

    public Act_Type getType() {
        return type;
    }

    public void setType(Act_Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Activity> getActs() {
        return acts;
    }

    public void setActs(List<Activity> acts) {
        this.acts = acts;
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
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Report[ id=" + id + " ]";
    }
    
}
