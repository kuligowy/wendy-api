/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
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
import pl.kuligowy.models.users.Permission;

/**
 *
 * @author coolig
 */
@Entity
@Table(name = "menu_block_item")
@NamedQueries({
    @NamedQuery(name = "MenuBlockItem.findAll", query = "SELECT m FROM MenuBlockItem m")})
public class MenuBlockItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "sort")
    private Integer sort;
    @JoinColumn(name = "menu_block_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private MenuBlock menuBlockId;
//    @OneToMany(mappedBy = "menuBlockItemId")
//    @JsonManagedReference
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference
    private Permission permissionId;

    public MenuBlockItem() {
    }

    public MenuBlockItem(Integer id) {
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public MenuBlock getMenuBlockId() {
        return menuBlockId;
    }

    public void setMenuBlockId(MenuBlock menuBlockId) {
        this.menuBlockId = menuBlockId;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
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
        if (!(object instanceof MenuBlockItem)) {
            return false;
        }
        MenuBlockItem other = (MenuBlockItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.test.MenuBlockItem[ id=" + id + " ]";
    }
    
}
