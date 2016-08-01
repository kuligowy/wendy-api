/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.methods.Action;

/**
 *
 * @author coolig
 */
@JsonRootName(value = "worder")
public class WOrderResource extends ResourceSupport implements Serializable {

//    private Integer id;
    private Date timeoforder;
    private String description;
    private String owner;
    private String statusId;
    private List<Action> actionList;

    public WOrderResource(WOrder order) {
//        this.id = order.getId();
        this.timeoforder = order.getTimeoforder();
        this.description = order.getDescription();
        this.owner = order.getUserId().getLogin();
        this.statusId = order.getStatusId().getTitle();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WOrderResource other = (WOrderResource) obj;
        if (this.timeoforder != other.timeoforder && (this.timeoforder == null || !this.timeoforder.equals(other.timeoforder))) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }

        if ((this.statusId == null) ? (other.statusId != null) : !this.statusId.equals(other.statusId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.timeoforder != null ? this.timeoforder.hashCode() : 0);
        hash = 79 * hash + (this.description != null ? this.description.hashCode() : 0);
//        hash = 79 * hash + (this.ownerId != null ? this.ownerId.hashCode() : 0);
        hash = 79 * hash + (this.statusId != null ? this.statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.orders.WOrder[ id=" + hashCode() + " ]";
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public List<Action> getActionList() {
        return actionList;
    }

}
