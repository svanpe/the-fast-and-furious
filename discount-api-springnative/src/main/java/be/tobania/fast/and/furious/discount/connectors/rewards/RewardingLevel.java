package be.tobania.fast.and.furious.discount.connectors.rewards;

public enum RewardingLevel {

    BRONZE(0, 500),
    SILVER(501, 1000),
    GOLD(1001, null);

    private Integer min;
    private Integer max;

    RewardingLevel(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    boolean isInRange(Integer number) {
        if (number >= min && (max == null || number <= max)) {
            return true;
        }

        return false;
    }
}