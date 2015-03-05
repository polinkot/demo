package demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SortType implements Serializable {
    @Id
    @GeneratedValue
    private Long sortTypeId;

    @Column
    private String name;

    @Column
    private double cost = Math.random();

//    @OneToMany(mappedBy = "sortType")
//    private List<Order> orders;

    public SortType() {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getSortTypeId() {
        return sortTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Order> getOrders() {
//        //TODO:!!!
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        //TODO:!!!
//        this.orders = orders;
//    }
}
