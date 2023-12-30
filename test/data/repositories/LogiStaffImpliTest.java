package data.repositories;

import data.models.LogisticsStaffCo;
import data.models.Orders;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogiStaffImpliTest {
    LogiStaffImpli logiStaffImpli = new LogiStaffImpli();
    LogisticsStaffCo logisticsStaffCo = new LogisticsStaffCo();
    @Test
    void peopleCanRegisterToBeADeliveryStaff(){
        logiStaffImpli.addStaff("Ajao");
        assertTrue(logiStaffImpli.findStaffByName("Ajao"));
    }

    @Test
    void testThatStaffCanBeRemoveFromLogisticsSys(){
        logiStaffImpli.addStaff("Ajao");
        logiStaffImpli.addStaff("Staff1");
        logiStaffImpli.addStaff("Staff2");
//        DeliveryStaff deliveryStaff = new DeliveryStaff("Ajao");
        logiStaffImpli.removeStaff("Ajao"); // here i an do if the staff dot equal the name of the staff it can jst remove it
        assertFalse(logiStaffImpli.findStaffByName("Ajao"));
    }
//()->logiStaffImpli.findOrderByID(
    @Test
    void testLogisticsSysCanDeterminIfOrderSholdBeAcceptedOrRejected(){
        Orders orders = new Orders(19);
        assertThrows(RuntimeException.class, ()->logiStaffImpli.aceptOrdrDetermination(orders));
    }

@Test
    void test_that_logistics_SysCanAssignStaffForDelivery(){
    logiStaffImpli.addStaff("Ajao");
    Orders orders = new Orders(5);
    Orders orders1 = new Orders(7);
    logiStaffImpli.aceptOrdrDetermination(orders);
    logiStaffImpli.aceptOrdrDetermination(orders1);
    logiStaffImpli.assignStaffForDelivery();
    assertTrue(logiStaffImpli.checkIfAssignedByName("Ajao"));
}

//    @Test()
//    void testStaffPaymentDeliveryCanBeDetermineByTheLogisticSys(){
//        DeliveryStaff deliverStaff = new DeliveryStaff();
//        logiStaffImpli.assignStaffForDelivery();
//
//        deliverStaff.orderShipped();
//        logiStaffImpli.staffDeliveryPaymentDetermination();
//    }
}