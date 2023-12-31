package services;

public class LogisticsServiceImpli implements LogisticsCoService{
    StaffServiceRepo s = new StaffServiceRepo();
    @Override
    public void findStaff() {

    }

    @Override
    public boolean loginAsLogisticStaff(String pin) {
        return false;
    }

    @Override
    public void joinDeliveryStaffs(String name) {

    }

    @Override
    public void placeAnOrder(String name, int size) {

    }

    @Override
    public void findIfOrderIsConfirmed(String name) {

    }

    @Override
    public void findOrderStatus(String order) {

    }
}
