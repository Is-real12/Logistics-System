package data.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LogisticsStaffCo {
    private List<String> deliveryStaff = new ArrayList<>();
    private List<Orders> acceptedOrders = new ArrayList<>();
    private List<Orders> rejectedOrders = new ArrayList<>();
    private List<OrderStatus> orderStatuses = new ArrayList<>();
    private List<String> staffAssignedForDelivery = new ArrayList<>();
    private LocalTime localTime ;


    public List<String> getStaffAssignedForDelivery() {
        return staffAssignedForDelivery;
    }

    public void setStaffAssignedForDelivery(String staffAssignedForDelivery) {
        this.staffAssignedForDelivery.add(staffAssignedForDelivery);
    }

    public LocalTime getLocalTime() {
        return localTime = LocalTime.now();
    }

    public List<String> getDeliveryStaff() {
        return deliveryStaff;
    }

    public void setDeliveryStaff(String deliveryStaff) {
        this.deliveryStaff.add(deliveryStaff);
    }

    public List<Orders> getAcceptedOrder() {
        return acceptedOrders;
    }

    public void setAcceptedOrder(Orders acceptedOrders) {
        this.acceptedOrders.add(acceptedOrders);
    }

    public void setRejectedOrder(Orders acceptedOrders) {
        this.rejectedOrders.add(acceptedOrders);
    }


}
