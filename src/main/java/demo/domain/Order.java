package demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "demo_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "sortTypeId")
    private SortType sortType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", sortType=" + sortType +
                ", user=" + user +
                ", list='" + list + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
