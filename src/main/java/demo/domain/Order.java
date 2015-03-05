package demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

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
    private ArrayList<String> list = new ArrayList<String>();

    public Order() {
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public Long getOrderId() {
        return orderId;
    }
}
