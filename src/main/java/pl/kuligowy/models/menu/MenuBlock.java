/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author coolig
 */
@Entity
@Table(name = "menu_block")
@NamedQueries({
    @NamedQuery(name = "MenuBlock.findByUser",
            query = "SELECT distinct mb FROM User u,MenuBlock mb "
            + " LEFT JOIN u.permissionList upl "
            + " LEFT JOIN u.roleId.permissionList rpl "
            + " JOIN mb.menuBlockItemList mbi "
            + "WHERE (mbi.permissionId.id = upl.id  OR  mbi.permissionId.id = rpl.id  ) "
            + "  AND u.id = ?1 "
            + "ORDER BY mb.sort asc ")})
public class MenuBlock implements Serializable  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "sort")
    private Integer sort;
    @JsonManagedReference
    @OneToMany(mappedBy = "menuBlockId")
    private List<MenuBlockItem> menuBlockItemList;

    public MenuBlock() {
    }

    public MenuBlock(Integer id) {
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<MenuBlockItem> getMenuBlockItemList() {
        return menuBlockItemList;
    }

    public void setMenuBlockItemList(List<MenuBlockItem> menuBlockItemList) {
        this.menuBlockItemList = menuBlockItemList;
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
        if (!(object instanceof MenuBlock)) {
            return false;
        }
        MenuBlock other = (MenuBlock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.test.MenuBlock[ id=" + id + " ]";
    }

}
