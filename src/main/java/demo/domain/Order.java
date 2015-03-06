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
    private ArrayList<String> list = new ArrayList<String>();

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    public void setList(ArrayList<String> list) {
        if (list == null) {
            return;
        }

        this.list = list;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
