package services;

import data.repositories.DeliveryStaffImpli;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import data.models.DeliveryStaff;
import data.models.Orders;
import data.repositories.DeliveryStaffImpli;
import org.junit.jupiter.api.Test;

class LogisticsServiceImpliTest {

        LogisticsServiceImpli logisticsServiceImpli = new LogisticsServiceImpli();

        @Test
        void testThatNobodyCanAccessTheyLogisticSystemIfTheyDontLogIn() {
            logisticsServiceImpli.joinDeliveryStaffs("Ajao");
            assertThrows(RuntimeException.class, () -> logisticsServiceImpli.fireStaff("Ajao"));
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

