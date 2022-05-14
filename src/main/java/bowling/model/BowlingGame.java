package bowling.model;

import bowling.model.frame.Frame;
import bowling.model.frame.Frames;

import java.util.List;

public class BowlingGame {

    private final Frames frames;

    private final Player player;

    private BowlingGame(Frames frames, Player player) {
        this.frames = frames;
        this.player = player;
    }

    public static BowlingGame of(Frames frames, Player player) {
        return new BowlingGame(frames, player);
    }

    public void pitch(Pins pins) {
        frames.pitch(pins);
    }

    public boolean isRunning() {
        return frames.isRunning();
    }

    public List<Frame> getFrames() {
        return frames.getFrames();
    }

    public int getCurrentRound() {
        return frames.getCurrentRound();
    }

    public Player getPlayer() {
        return player;
    }

}