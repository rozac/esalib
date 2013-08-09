package common.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roza
 * Date: 04/08/13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class Category {

    String name;
    Integer size;
    double esaCoeff;
    private Category parent;
    List<Category> subcategories;

    public String getName() {
        return name;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public double getEsaCoeff() {
        return esaCoeff;
    }

    public void setEsaCoeff(double esaCoeff) {
        this.esaCoeff = esaCoeff;
    }

    public boolean hasChildren(){
        return subcategories != null && subcategories.size() != 0;
    }

    Category(String name){
        this.name = name;
        this.parent = this;
        subcategories = new ArrayList<Category>();
    }

    public Category addSubcategory(String name){
        Category c = new Category(name);
        this.subcategories.add(c);
        c.parent = this;
        return c;
    }





}
