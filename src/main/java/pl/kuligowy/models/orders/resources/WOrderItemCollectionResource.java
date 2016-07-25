/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author mkuligowski
 */
public class WOrderItemCollectionResource extends ResourceSupport {

    private int size;
    @JsonProperty(value = "_embeded")
    private List<WOrderItemResource> items;

    public WOrderItemCollectionResource(List<WOrderItemResource> list) {
        this.items = list;
        this.size = list.size();
    }

    public List<WOrderItemResource> getItems() {
        return items;
    }

    public void setItems(List<WOrderItemResource> items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
