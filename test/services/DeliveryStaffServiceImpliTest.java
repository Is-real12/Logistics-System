package services;

import data.repositories.DeliveryStaffImpli;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStaffServiceImpliTest {
    LogisticsServiceImpli logisticsServiceImpli = new LogisticsServiceImpli();


    @Test
    void testThatOnlyStaffCanCanLogIn() {
        StaffServiceImpli staffServiceImpli = new StaffServiceImpli();

    }

    @Test
    void testThatStaffCanAdd_and_FireDeliverStaff() {
        logisticsServiceImpli.loginAsLogisticStaff("admin");
        logisticsServiceImpli.joinDeliveryStaffs("Ajao");
        logisticsServiceImpli.fireStaff("Ajao");
        assertThrows(RuntimeException.class, () -> logisticsServiceImpli.staffExist("Ajao"));

    }

    @Test
    void testThatStaffCanAssignDeliveryStaffToDeliverOrder() {
        logisticsServiceImpli.loginAsLogisticStaff("admin");
        logisticsServiceImpli.joinDeliveryStaffs("Ajao");

        logisticsServiceImpli.placeAnOrder("Rice", 3);
        DeliveryStaffImpli deliveryStaff = logisticsServiceImpli.assignStaffForDelivery();
        assertEquals(1, deliveryStaff.findAll().size());

    }

    @Test
    void testThatStaffCanGetAllAvailableStaff() {
        logisticsServiceImpli.loginAsLogisticStaff("admin");
        logisticsServiceImpli.joinDeliveryStaffs("Ajao");
        logisticsServiceImpli.joinDeliveryStaffs("Ajao1");
        assertEquals(2, logisticsServiceImpli.getAllStaffAvailable().size());

    }
}