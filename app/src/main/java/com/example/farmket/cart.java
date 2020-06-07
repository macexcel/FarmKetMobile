package com.example.farmket;

public class cart {

    int id, price, amount, total;
    String item, farmer, weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public cart(int id, String item, String farmer, int price, String weight, int amount, int total){
        this.id = id;
        this.item = item;
        this.farmer = farmer;
        this.price = price;
        this.weight = weight;
        this.amount = amount;
        this.total = total;
    }
}
