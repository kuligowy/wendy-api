/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author coolig
 */
@Entity
@Table(name = "worder_item")
@NamedQueries({
    @NamedQuery(name = "WOrderItem.findAll", query = "SELECT w FROM WOrderItem w"),
    @NamedQuery(name = "WOrderItem.findById", query = "SELECT w FROM WOrderItem w WHERE w.id = :id"),
    @NamedQuery(name = "WOrderItem.findByPrice", query = "SELECT w FROM WOrderItem w WHERE w.price = :price"),
    @NamedQuery(name = "WOrderItem.findByQuantity", query = "SELECT w FROM WOrderItem w WHERE w.quantity = :quantity"),
    @NamedQuery(name = "WOrderItem.findByDescription", query = "SELECT w FROM WOrderItem w WHERE w.description = :description")})
public class WOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplierId;
    @JoinColumn(name = "worder_id", referencedColumnName = "id")
    @ManyToOne
    private WOrder worderId;

    public WOrderItem() {
    }

    public WOrderItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public WOrder getWorderId() {
        return worderId;
    }

    public void setWorderId(WOrder worderId) {
        this.worderId = worderId;
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
        if (!(object instanceof WOrderItem)) {
            return false;
        }
        WOrderItem other = (WOrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kuligowy.models.orders.WOrderItem[ id=" + id + " ]";
    }
    
}
