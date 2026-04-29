public class Main {
    public static void main(String[] args) {

        Driver d = new Driver("D1204", "Kavita Nair");

        d.routeHistory.addCheckpoint(new DeliveryCheckpoint("C1", "Warehouse A", 40, 30, 40));
        d.routeHistory.addCheckpoint(new FuelCheckpoint("C2", "Pump 12", 20, 15, 15));
        d.routeHistory.addCheckpoint(new RestCheckpoint("C3", "Motel X", 10, 20, 55));
        d.routeHistory.addCheckpoint(new DeliveryCheckpoint("C4", "Client Hub", 50, 25, 40));

        d.printSummary();
    }
}