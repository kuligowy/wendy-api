/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author coolig
 */
@Entity
@Table(name = "worder" )
@NamedQueries({
    @NamedQuery(name = "WOrder.findAll", query = "SELECT w FROM WOrder w"),
    @NamedQuery(name = "WOrder.findById", query = "SELECT w FROM WOrder w WHERE w.id = :id"),
    @NamedQuery(name = "WOrder.findByTimeoforder", query = "SELECT w FROM WOrder w WHERE w.timeoforder = :timeoforder"),
    @NamedQuery(name = "WOrder.findByDescription", query = "SELECT w FROM WOrder w WHERE w.description = :description"),
    @NamedQuery(name = "WOrder.findByOwnerId", query = "SELECT w FROM WOrder w WHERE w.ownerId = :ownerId")})
public class WOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "timeoforder")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeoforder;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "owner_id")
    private Integer ownerId;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private WOrderStatus statusId;
    @OneToMany(mappedBy = "worderId")
    private List<WOrderItem> wOrderItemList;

    public WOrder() {
    }

    public WOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimeoforder() {
        return timeoforder;
    }

    public void setTimeoforder(Date timeoforder) {
        this.timeoforder = timeoforder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public WOrderStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(WOrderStatus statusId) {
        this.statusId = statusId;
    }

    public List<WOrderItem> getWOrderItemList() {
        return wOrderItemList;
    }

    public void setWOrderItemList(List<WOrderItem> wOrderItemList) {
        this.wOrderItemList = wOrderItemList;
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
        if (!(object instanceof WOrder)) {
            return false;
        }
        WOrder other = (WOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.orders.WOrder[ id=" + id + " ]";
    }
    
}
