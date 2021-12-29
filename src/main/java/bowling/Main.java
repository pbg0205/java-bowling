package bowling;

import bowling.domain.BowlingGame;
import bowling.domain.BowlingGames;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int playersCount = InputView.readPlayersCount();
        List<String> playersName = InputView.readPlayersName(playersCount);

        BowlingGames bowlingGames = new BowlingGames(playersName);
        OutputView.printBowlingBoard(bowlingGames.values());

        while (!bowlingGames.isEnd()) {
            playBowlingGames(bowlingGames.values());
        }
    }

    private static void playBowlingGames(List<BowlingGame> bowlingGames) {
        for (BowlingGame bowlingGame : bowlingGames) {
            playBowlingGameAndPrintScore(bowlingGames, bowlingGame);
        }
    }

    private static void playBowlingGameAndPrintScore(List<BowlingGame> bowlingGames, BowlingGame bowlingGame) {
        bowlingGame.prepareFrame();
        while (!bowlingGame.isCurrentFrameEnd()) {
            int knockedOutCount = InputView.readKnockedOutCountOf(bowlingGame);
            bowlingGame.bowl(knockedOutCount);
            OutputView.printBowlingBoard(bowlingGames);
        }
    }
}