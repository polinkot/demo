package demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SortType implements Serializable {
    @Id
    @GeneratedValue
    private Long sortTypeId;

    @Column
    private String key;

    @Column
    private String name;

    @Column
    private double cost = Math.random();

//    @OneToMany(mappedBy = "sortType")
//    private List<Order> orders;

    public SortType() {
    }

    public Long getSortTypeId() {
        return sortTypeId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
