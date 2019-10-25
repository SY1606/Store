package com.science.com.rchs.data.bean;

public class CodeList {
    private String money;
    private String name;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CodeList{" +
                "money='" + money + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
