package demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SortType implements Serializable {
    @Id
    @GeneratedValue
    private Long sortTypeId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SortTypeKey key;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double cost;

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

    public SortTypeKey getKey() {
        return key;
    }

    public void setKey(SortTypeKey key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SortType{" +
                "sortTypeId=" + sortTypeId +
                ", key=" + key +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
