/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
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
import org.springframework.hateoas.ResourceSupport;
import pl.kuligowy.models.orders.WOrderStatus;

/**
 *
 * @author coolig
 */
public class WOrderResource extends ResourceSupport implements Serializable {

    private Integer id;
    private Date timeoforder;
    private String description;
    private Integer ownerId;
    private WOrderStatus statusId;

    public WOrderResource() {
    }

    public WOrderResource(Integer id) {
        this.id = id;
    }

    @JsonProperty(value = "id")
    public Integer getObjectId() {
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WOrderResource)) {
            return false;
        }
        WOrderResource other = (WOrderResource) object;
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
