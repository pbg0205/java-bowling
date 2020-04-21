package bowling.domain.score;

import bowling.domain.scores.Scores;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ScoreTest {
    @DisplayName("일반 프레임 1구 점수 생성")
    @Test
    void createDefaultFrameScore() {
        assertThatCode(() -> ScoreGenerator.nextScore(10));
    }

    @DisplayName("점수가 10점이 넘거나 음수일 경우 throws Exception")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void createScoreFailbyInvalidPoint(int point) {
        assertThatIllegalArgumentException().isThrownBy(() -> ScoreGenerator.nextScore(point));
    }

    @Nested
    @DisplayName("일반 프레임 점수")
    class defaultFrame {

        @DisplayName("스트라이크 생성")
        @Test
        void createStrike() {
            Score strike = ScoreGenerator.nextScore(10);

            assertThat(strike.isEqualScoreType(ScoreType.STRIKE)).isTrue();
        }

        @DisplayName("스페어 생성")
        @Test
        void createSpare() {
            Scores lastScores = new Scores();
            lastScores.add(5);
            lastScores.add(5);

            List<Score> scores = lastScores.getScores();
            Score spare = scores.get(scores.size() - 1);

            assertThat(spare.isEqualScoreType(ScoreType.SPARE)).isTrue();
        }

        @DisplayName("거터 생성")
        @Test
        void createGutter() {
            Score gutter = ScoreGenerator.nextScore(0);

            assertThat(gutter.isEqualScoreType(ScoreType.GUTTER)).isTrue();
        }

        @DisplayName("미스 생성")
        @Test
        void createMiss() {
            Score miss = ScoreGenerator.nextScore(5);

            assertThat(miss.isEqualScoreType(ScoreType.MISS)).isTrue();
        }
    }

    @Nested
    @DisplayName("마지막 프레임 점수")
    class lastFrame {

        @DisplayName("스트라이크 생성")
        @Test
        void createStrike() {
            Scores scores = new Scores();

            scores.add(10);
            scores.add(10);
            scores.add(10);

            assertAll(
                    () -> {
                        for (Score score : scores.getScores()) {
                            assertThat(score.isEqualScoreType(ScoreType.STRIKE)).isTrue();
                        }
                    }
            );
        }
    }
}