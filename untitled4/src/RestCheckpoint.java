class RestCheckpoint extends Checkpoint {

    public RestCheckpoint(String id, String loc, double dist, int exp, int act) {
        super(id, loc, dist, exp, act);
    }

    boolean isCritical() {
        return false;
    }

    String getType() {
        return "RestCheckpoint";
    }

    double calculatePenalty() {
        if (actualDuration - expectedDuration > 30) {
            return (actualDuration - expectedDuration) * 0.5;
        }
        return 0;
    }
}