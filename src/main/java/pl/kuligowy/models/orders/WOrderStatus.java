/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author coolig
 */
@Entity
@Table(name = "worder_status")
@NamedQueries({
    @NamedQuery(name = "WOrderStatus.findAll", query = "SELECT w FROM WOrderStatus w"),
    @NamedQuery(name = "WOrderStatus.findById", query = "SELECT w FROM WOrderStatus w WHERE w.id = :id"),
    @NamedQuery(name = "WOrderStatus.findByTitle", query = "SELECT w FROM WOrderStatus w WHERE w.title = :title"),
    @NamedQuery(name = "WOrderStatus.findByDescription", query = "SELECT w FROM WOrderStatus w WHERE w.description = :description")})
public class WOrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "title")
    private String title;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "statusId")
    private List<WOrder> wOrderList;

    public WOrderStatus() {
    }

    public WOrderStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WOrder> getWOrderList() {
        return wOrderList;
    }

    public void setWOrderList(List<WOrder> wOrderList) {
        this.wOrderList = wOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WOrderStatus)) {
            return false;
        }
        WOrderStatus other = (WOrderStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.orders.WorderStatus[ id=" + id + " ]";
    }
    
}
