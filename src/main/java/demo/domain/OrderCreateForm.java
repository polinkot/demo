package demo.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class OrderCreateForm {

    @NotEmpty
    private String list = "";

    private String result = "";

    @NotEmpty
    private int sortType = 1;

    @NotEmpty
    private long userId;

    private boolean saved;

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

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    @Override
    public String toString() {
        return "OrderCreateForm{" +
                "list='" + list + '\'' +
                ", result='" + result + '\'' +
                ", sortType=" + sortType +
                ", userId=" + userId +
                ", saved=" + saved +
                '}';
    }
}
