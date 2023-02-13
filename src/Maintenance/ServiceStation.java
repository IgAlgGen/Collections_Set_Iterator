package Maintenance;

import Transport.Transport;

import java.util.Queue;

public class ServiceStation {
    private final Queue<Transport<?>> queueOfVehicles;

    public ServiceStation(Queue<Transport<?>> queueOfVehicles) {
        this.queueOfVehicles = queueOfVehicles;
    }

    public void addTransport(Transport<?> transport) {
        if (transport.isNeedService()) {
            queueOfVehicles.add(transport);
        }
    }

    public void doService() {
        if (!queueOfVehicles.isEmpty()) {
            Transport<?> transport = queueOfVehicles.poll();
            transport.getMechanicList().get((int) (Math.random() * (transport.getMechanicList().size()))).doMaintenance(transport);
        }
    }

}
