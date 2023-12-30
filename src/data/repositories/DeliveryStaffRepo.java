package data.repositories;

import data.models.OrderStatus;
import data.models.Orders;

import java.util.List;

public interface DeliveryStaffRepo {


    void finishDelivery(); // the one for statusDelivery // to confirm and deliver
    void determinToFinish();
    void viewStatus(String name);

    void removeDelivery(Orders name);

    void logIn();

     void logOut();

    Orders findToOrder(String orderName);

    List<Orders> findAll();

    OrderStatus findStatusByOrderName(String name);


    void logisticsToDeliver(Orders orders,  String s);


}
