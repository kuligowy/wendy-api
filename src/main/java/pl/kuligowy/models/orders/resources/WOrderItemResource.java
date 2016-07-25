/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Supplier;
import java.math.BigDecimal;
import org.springframework.hateoas.ResourceSupport;
import pl.kuligowy.models.orders.Product;
import pl.kuligowy.models.orders.WOrderItem;

/**
 *
 * @author mkuligowski
 */
@JsonRootName(value = "worderItem")
public class WOrderItemResource extends ResourceSupport {

    private Integer id;
    private BigDecimal price;
    private BigDecimal quantity;
    private String description;
    @JsonIgnore
    private Product productId;
    @JsonIgnore
    private Supplier supplierId;

    public WOrderItemResource(WOrderItem entity) {
        this.id = entity.getId();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.description = entity.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty(value = "id")
    public Integer getObjectId() {
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

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }
}
