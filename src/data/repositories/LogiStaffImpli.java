package data.repositories;

import data.models.DeliveryStaff;
import data.models.LogisticsStaffCo;
import data.models.Orders;

import java.util.List;
import java.util.Random;

public class LogiStaffImpli implements LogiStaffRepo {
  public LogisticsStaffCo logisticsStaffCo = new LogisticsStaffCo();
  private DeliveryStaffImpli randStaff;
  Random random = new Random();
    private DeliveryStaff deliveryStaff= new DeliveryStaff();
  @Override
    public void aceptOrdrDetermination(Orders orders){
        if (orders.getOrderSize() > 10 ){
            rejectOrder(orders);
        }else {
            acceptOrder(orders);}}

    @Override
    public void addStaff(String name) {
        logisticsStaffCo.setDeliveryStaff(name);
    }

    @Override
    public void removeStaff(String name) {
        int index = -1;
        for (String d : logisticsStaffCo.getDeliveryStaff()) {
            if (d.equals(name)){
                index = logisticsStaffCo.getDeliveryStaff().indexOf(d);
            }else {
                break;
            }
        }
        if(index > -1) {
            String deliveryStaff1 = logisticsStaffCo.getDeliveryStaff().get(index);
            logisticsStaffCo.getDeliveryStaff().remove(deliveryStaff1);}}

    @Override
    public void acceptOrder(Orders ordersName) {
        logisticsStaffCo.setAcceptedOrder(ordersName);
    }

    @Override
    public void rejectOrder(Orders orders) {
      logisticsStaffCo.setRejectedOrder(orders);
         throw new RuntimeException("This orders has been Rejected");
    }

    @Override
    public boolean checkIfAssignedByName(String name) {
      DeliveryStaff deliveryStaff = new DeliveryStaff();
      deliveryStaff.setStaffName(name);
        for (String logis: logisticsStaffCo.getStaffAssignedForDelivery()) {
            if (logis.equals(deliveryStaff.getStaffName())) {
                return true;
            }else {
               break;
            }
        }
        return false;
    }

    @Override
    public void assignStaffForDelivery() {
        List<Orders> acceptedOrders = logisticsStaffCo.getAcceptedOrder();
        List<String> staff = logisticsStaffCo.getDeliveryStaff();
        int OrderNum = random.nextInt(0, acceptedOrders.size());
        int staffNum = random.nextInt(0, staff.size());

        if (!acceptedOrders.isEmpty() && !staff.isEmpty()) {
            logisticsStaffCo.setStaffAssignedForDelivery(staff.get(staffNum));
            DeliveryStaff deliveryStaff1 = new DeliveryStaff();
            DeliveryStaffImpli deliveryStaffImpli = new DeliveryStaffImpli();
            randStaff = deliveryStaffImpli;
            deliveryStaff1.setStaffName(staff.get(staffNum));
            deliveryStaffImpli.logisticsToDeliver(acceptedOrders.get(OrderNum), staff.get(staffNum));
            deliveryStaff1.setExpectedTime(logisticsStaffCo.getLocalTime());
            logisticsStaffCo.getAcceptedOrder().remove(logisticsStaffCo.getAcceptedOrder().get(OrderNum));

        } else {
            throw new RuntimeException("There are no available staffs or order");
        }
    }
    public List<Orders> allAcceptedOrder(){
      return logisticsStaffCo.getAcceptedOrder();
    }

    public DeliveryStaffImpli getRandStaff()
    {
        return randStaff;
    }

    @Override
    public List<String> getStaffAssignedForDelivery() {
        return logisticsStaffCo.getStaffAssignedForDelivery();
    }

    @Override // todo check this out
    public boolean findStaffByName(String name) {
        DeliveryStaff deliveryStaff = new DeliveryStaff();
        deliveryStaff.setStaffName(name);
        for (String logis: logisticsStaffCo.getDeliveryStaff()) {
            if (logis.equals(deliveryStaff.getStaffName())) return true;
        }
         throw new RuntimeException("Staff not found");
        }

        @Override
    public List<String> getAllStaff(){
     return logisticsStaffCo.getDeliveryStaff();
        }



    }

