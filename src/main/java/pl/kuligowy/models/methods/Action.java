/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.methods;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kuligowy.models.orders.WOrder;

/**
 *
 * @author mkuligowski
 */
public class Action implements Serializable {

    private String name;
    private String title;
    private String method;
    private String link;
    private String type;
    private List<Field> fields;

    public Action() {
        fields = Lists.newArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }

    static class ActionBuilder {

        private final WOrder worder;
        private final Action action;

        public ActionBuilder(WOrder worder, String link, RequestMethod method) {
            this.worder = worder;
            this.action = new Action();
            this.action.setLink(link);
            this.action.setMethod(method.toString());

        }

        public ActionBuilder name(String s) {
            this.action.name = s;
            return this;
        }

        public ActionBuilder title(String s) {
            this.action.title = s;
            return this;
        }

        public ActionBuilder type(String s) {
            this.action.type = s;
            return this;

        }

        public Action build() {
            return this.action;
        }

    }

}
