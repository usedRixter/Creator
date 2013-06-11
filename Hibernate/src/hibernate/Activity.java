/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import enums.Act_Type;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author rixter
 */
@Entity
@Table
public class Activity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    
    // Columns
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;
    
    @Column(name = "hours")
    private int hours;
    @Column(name="type")
    private Act_Type type;
    @Column(name="act_number")
    private Long act_number;
    @Column(name="act_name")
    String act_name;
    @Column(name="act_description")
    String act_description;
    @Column(name="rep_id")
    private Long rep_id;
    
    // Relations
    @ManyToOne
    private Report report;
    
    // Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Act_Type getType() {
        return type;
    }

    public void setType(Act_Type type) {
        this.type = type;
    }

    public long getAct_number() {
        return act_number;
    }

    public void setAct_number(long act_number) {
        this.act_number = act_number;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getAct_description() {
        return act_description;
    }

    public void setAct_description(String act_description) {
        this.act_description = act_description;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Activity[ id=" + id + " ]";
    }
    
}
