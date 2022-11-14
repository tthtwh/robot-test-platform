package com.luckyframe.project.testmanagmt.projectK8s.domain;

import java.util.List;

public class JsonRootBean {

    private List<Items> items;
    private int totalItems;
    public void setItems(List<Items> items) {
        this.items = items;
    }
    public List<Items> getItems() {
        return items;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
    public int getTotalItems() {
        return totalItems;
    }

}
