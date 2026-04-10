abstract class Checkpoint {
    String checkpointId;
    String locationName;
    double distanceFromLast;
    int expectedDuration;
    int actualDuration;

    public Checkpoint(String checkpointId, String locationName, double distanceFromLast, int expectedDuration, int actualDuration) {
        this.checkpointId = checkpointId;
        this.locationName = locationName;
        this.distanceFromLast = distanceFromLast;
        this.expectedDuration = expectedDuration;
        this.actualDuration = actualDuration;
    }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public int getDelay() {
        return Math.max(0, actualDuration - expectedDuration);
    }

    abstract double calculatePenalty();
    abstract boolean isCritical();
    abstract String getType();
}


class DeliveryCheckpoint {
    public DeliveryCheckpoint(String id, String loc, double dist, int exp, int act) { super(id, loc, dist, exp, act); }
    @Override double calculatePenalty() { return isDelayed() ? getDelay() * 2.0 : 0.0; }
    @Override boolean isCritical() { return true; }
    @Override String getType() { return "DeliveryCheckpoint"; }
}

class FuelCheckpoint {
    public FuelCheckpoint(String id, String loc, double dist, int exp, int act) { super(id, loc, dist, exp, act); }
    @Override double calculatePenalty() { return isDelayed() ? 10.0 : 0.0; }
    @Override boolean isCritical() { return true; }
    @Override String getType() { return "FuelCheckpoint"; }
}

class RestCheckpoint {
    public RestCheckpoint(String id, String loc, double dist, int exp, int act) { super(id, loc, dist, exp, act); }
    @Override double calculatePenalty() { return (isDelayed() && getDelay() > 30) ? getDelay() * 0.5 : 0.0; }
    @Override boolean isCritical() { return false; }
    @Override String getType() { return "RestCheckpoint"; }
}
