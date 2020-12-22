package bowling.domain;

public class NormalFrame extends Frame{

    private static final int MAX_PITCH_COUNT = 2;

    private NormalFrame(int index){
        super(index);
    }

    public static NormalFrame from(int index){
        return new NormalFrame(index);
    }

    @Override
    public void start(PitchStrategy pitchStrategy) {
        if (!isEnd()) {
            int pitchResult = pitchStrategy.makePitchResult(countLeftOverPins());
            pitchResults.addNewResult(pitchResult);
        }
    }

    private int countLeftOverPins() {
        int currentPoint = sumCurrentPitchResults();
        return BOWLING_PIN_COUNT - currentPoint;
    }

    @Override
    public boolean isEnd() {
        return countLeftOverPins() == 0 || pitchResults.size() == MAX_PITCH_COUNT;
    }

    @Override
    public Frame makeNextFrame(int currentFrameIndex) {
        if (currentFrameIndex == MAX_FRAME_COUNT - 1) {
            return FinalFrame.from(MAX_FRAME_COUNT);
        }

        return NormalFrame.from(currentFrameIndex + 1);
    }



}
