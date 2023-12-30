package data.models;

public class Orders {
    private int orderSize ;
    private String name;

    public Orders(int size){
    this.orderSize = size;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public String getOrderName() {
        return this.name;
    }

    public void setOrderName(String biscute) {
    }
}
