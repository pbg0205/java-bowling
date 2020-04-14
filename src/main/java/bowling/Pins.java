package bowling;

public class Pins {

    public static final int MAX_PIN_COUNT = 10;
    public static final int MIN_PIN_COUNT = 0;

    private int pinCount;

    public Pins() {
        this.pinCount = MAX_PIN_COUNT;
    }

    public boolean isRemain(final int count) {
        return pinCount == count;
    }

    public int drop(final int dropPinCount) {
        deductPins(dropPinCount);
        return dropPinCount;
    }

    private void deductPins(final int dropPinCount) {
        if (pinCount < dropPinCount) {
            throw new IllegalStateException("Remain pin count must be greater than dropping pin count.");
        }

        pinCount -= dropPinCount;
    }

    public void reset() {
        this.pinCount = MAX_PIN_COUNT;
    }
}