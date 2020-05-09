# 볼링 점수판

## 기능 목록

- 스트라이크, 스페어, 미스, 거터를 구분하는 기능
- 쓰러진 볼링핀의 수는 0~10 사이로 랜덤하게 결정
- 스트라이크가 나오지 않으면 해당 프레임에서 한 번 더 투구할 수 있는 기능
- 10 프레임일 때 스트라이크 or 스페어면 한 번 더 투구하는 기능

### 등장하는 객체

Bowling
- 볼링볼을 굴려서 게임 진행을 담당

Frame
- 각 프레임의 결과, 종료 등 상태를 관리하는 책임
- 다음 프레임의 생성을 담당

NormalFrame
- 1~9에 해당하는 프레임에 대한 처리를 담당
FinalFrame
- 10 프레임에서 스트라이크이거나 스페어이면 한 번 더 투구 가능 

Pins
- 볼링핀이 쓰러진 갯수, 현재 남은 볼링핀 갯수 등을 관리

Player
- 볼링 게임에 참여하는 유저

InputView, ResultView
- 화면에서 사용자의 입력과 출력을 담당