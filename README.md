# 볼링 게임 점수판
## 진행 방법
* 볼링 게임 점수판 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## QnA 요구사항
- [x] 질문 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.
- [x] 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
- [x] 답변이 없는 경우 삭제가 가능하다.
- [x] 질문자와 답변글의 모든 답변자 같은 경우 삭제가 가능하다.
- [x] 질문을 삭제할 때 답변 또한 삭제해야 하며, 답변의 삭제 또한 삭제 상태(deleted)를 변경한다.
- [x] 질문자와 답변자가 다른경우 답변을 삭제할 수 없다.
- [x] 질문과 답변 삭제 이력에 대한 정보를 DeleteHistory 를 활용해 남긴다.

## 볼링 요구사항
- [x] 플레이어 한명의 이름을 입력 받는다.
  - [x] 이름의 길이는 정확히 3자여야 한다.
  - [x] 빈값이나 null 값이 들어오면 안된다.
- [x] 기본적으로 프레임은 총 10개의 프레임으로 구성된다.
- [x] 마지막 프레임에서는 스트라이크나 스페어일 경우 한 번 더 투구할 수 있다.
  - [x] 두번 연속 스트라이크일 경우 한번 더 투구할 수 있다.
- [x] 일반 프레임에서(1~9 프레임) 한 프레임당 투구는 최대 두번이다.
  - [x] 첫번째 투구에서 스트라이크의 경우 해당 프레임은 종료한다.
  - [x] 첫번쨰 투구에서 스트라이크를 치지 못한 경우, 투구를 한번 더 할 수 있다.
  - [x] 두번째 투구에서 남은 모든 핀을 쓰러뜨리면 스페어처리이다.
  - [x] 두번째 투구에서 남은 핀이 있다면 미스이다.
- [x] 각 프레임의 상태에 따라 표시법이 달라진다.
  - [x] 스트라이크는 X
  - [x] 스페어는 n|/
  - [x] 미스는 n|m
  - [x] 거터는 쓰러뜨린 핀이 없을경우이며 -로 표시한다.
- [x] 사용자 1명의 볼링 게임 점수를 관리할 수 있는 프로그램을 구현한다.
  - [x] 스트라이크는 다음 2번의 투구까지 점수를 합산해야 한다.
  - [x] 스페어는 다음 1번의 투구까지 점수를 합산해야 한다.
- [x] 1명 이상의 사용자가 사용할 수 있는 볼링게임 점수판을 구현한다.  