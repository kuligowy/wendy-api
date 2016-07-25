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
public class WOrderCollectionResource extends ResourceSupport {

    private int size;
    @JsonProperty(value = "_embeded")
    private List<WOrderResource> list;

    public WOrderCollectionResource(List<WOrderResource> list) {
        this.size = list.size();
        this.list = list;
    }

    public List<WOrderResource> getList() {
        return list;
    }

    public void setList(List<WOrderResource> list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
