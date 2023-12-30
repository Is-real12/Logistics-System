package data.repositories;

import data.models.Orders;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStaffImpliTest {
//    @Test
//    void staffCannotDoAnythingIfTheyDontLogIn(){
//        deliveryStaffImpli.logIn();
//        assertThrows(RuntimeException.class, ()->deliveryStaffImpli.logIn());
//    }

    DeliveryStaffImpli deliveryStaffImpli = new DeliveryStaffImpli();

    @Test
    void staffCanAddOrderTOBeDelivered(){
        Orders orders = new Orders(3);
        orders.setOrderName("Biscuit");
        Orders order = new Orders(3);
        orders.setOrderName("Biscute1");
        deliveryStaffImpli.logisticsToDeliver(orders, "AjaoJaBlack");
        deliveryStaffImpli.logisticsToDeliver(orders, "Ajao");
//        assertEquals(orders, deliveryStaffImpli.findToOrder("Biscuit"));
        assertEquals(2, deliveryStaffImpli.findAll().size());

    }

    @Test
    void staffCanReturnDeliveryBackToLogisticCo(){
        LogiStaffImpli logisticsStaffCo = new LogiStaffImpli();
        logisticsStaffCo.addStaff("Ajao");
        Orders orders = new Orders(3);
        logisticsStaffCo.aceptOrdrDetermination(orders);
        logisticsStaffCo.assignStaffForDelivery();
        DeliveryStaffImpli deliveryStaffImpli1 = logisticsStaffCo.getRandStaff();
        deliveryStaffImpli1.removeDelivery(orders);
        assertEquals(0, deliveryStaffImpli1.findAll().size());
        assertEquals(1, deliveryStaffImpli1.logisticsStaffCo.getAcceptedOrder().size());

    }

    @Test
    void staffCanFindOrderStatusWithOrderName(){
        Orders orders = new Orders(3);
        orders.setOrderName("Biscuit");
        deliveryStaffImpli.logisticsToDeliver(orders, "AjaoJale");
        deliveryStaffImpli.finishDelivery ();
        assertEquals(1, deliveryStaffImpli.findAllStatus().size());
    }
    @Test
    void staffCanDetermineWeatherToFinishDeliver(){
        Orders orders = new Orders(3);
        orders.setOrderName("Biscuit");
        Orders orders1 = new Orders(3);
        orders1.setOrderName("Biscuit1");
        deliveryStaffImpli.logisticsToDeliver(orders1, "AjaoJale1");
        deliveryStaffImpli.logisticsToDeliver(orders, "AjaoJale");

        assertEquals(1, deliveryStaffImpli.findAllStatus().size());

    }

    @Test
    void staffCanLogOut(){

    }

    @Test
    void staffCanConfirmDelivery(){
        deliveryStaffImpli.finishDelivery();

    }
}