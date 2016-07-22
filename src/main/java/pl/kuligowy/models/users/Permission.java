/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.users;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mkuligowski
 */
@Entity
@Table(name = "permission")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 4000)
    @Column(name = "name")
    private String name;
    @Column(name = "status_id")
    private BigInteger statusId;
    @Size(max = 4000)
    @Column(name = "function")
    private String function;
    @Size(max = 200)
    @Column(name = "function_type")
    private String functionType;
    @Size(max = 4000)
    @Column(name = "description")
    private String description;
    @Column(name = "step_id")
    private BigInteger stepId;
    @Column(name = "additional_type")
    private BigInteger additionalType;
    @Size(max = 2147483647)
    @Column(name = "icon")
    private String icon;
    @Size(max = 2147483647)
    @Column(name = "tabel")
    private String tabel;

    public Permission() {
    }

    public Permission(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getAdditionalType() {
        return additionalType;
    }

    public void setAdditionalType(BigInteger additionalType) {
        this.additionalType = additionalType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getStatusId() {
        return statusId;
    }

    public void setStatusId(BigInteger statusId) {
        this.statusId = statusId;
    }

    public BigInteger getStepId() {
        return stepId;
    }

    public void setStepId(BigInteger stepId) {
        this.stepId = stepId;
    }

    public String getTabel() {
        return tabel;
    }

    public void setTabel(String tabel) {
        this.tabel = tabel;
    }

//    public List<UserPermission> getUserPermissionList() {
//        return userPermissionList;
//    }
//
//    public void setUserPermissionList(List<UserPermission> userPermissionList) {
//        this.userPermissionList = userPermissionList;
//    }
//
//    public List<RolePermission> getRolePermissionList() {
//        return rolePermissionList;
//    }
//
//    public void setRolePermissionList(List<RolePermission> rolePermissionList) {
//        this.rolePermissionList = rolePermissionList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.users.Permission[ id=" + id + " ]";
    }
}
