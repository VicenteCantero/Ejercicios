package com.bosonit.ConfigurationProperties;

import org.springframework.stereotype.Component;

@Component
public class Item {
    private String name;
    private int qty;

    public Item(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
