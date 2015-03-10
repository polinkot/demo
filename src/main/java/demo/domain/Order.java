package demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "order1")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "sortTypeId")
    private SortType sortType;

    @Column
    private String list = "";

    @Column
    private String result = "";

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list == null ? "" : list;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? "" : result;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", sortType=" + sortType +
                ", list='" + list + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
