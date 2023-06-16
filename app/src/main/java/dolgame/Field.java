package dolgame;

public class Field {
/*
    카드 클래스 참조 변수 -> Player player = new Player
    플레이어 클래스 참조 변수 -> Card card = new Card
    플레이어 필드 카드 배열 -> Card[] myFieldCard = new Card[13]
        ArrayList<Card> myFieldCard = new ArrayList<Card>();
    컴퓨터 필드 카드 배열 -> Card[] computerFieldCard = new Card[13]
        ArrayList<Card> computerFieldCard = new ArrayList<Card>();

    1. 상대 카드(플레이어) 공격 -> attack()
        //공격 시 피해
        attack(myFieldCard.get(?), computerFieldCard.get(?)) {
            computerFieldCard.get(?).hp = computerFieldCard.get(?).hp - myFieldCard.get(?).atk
            myFieldCard.hp = myFieldCard.hp - computerFieldCard.get(?).atk
            System.out.println(myFieldCard.name + "이 " + computerFieldCard.get(?).name + "을(를) 공격하였습니다.);
            if(myFieldCard.get(?).hp <= 0) {
                deleteCard(공격카드);
            }

            if(myFieldCard.get(?).hp <= 0) {
                deleteCard(computerFieldCard.get(?));
            }
        }
    2. 카드 죽음 -> deleteCard()
        deleteCard(Card card){
            //프론트에 신호를 줘야함?
            System.out.println(card.name + "가 죽었습니다.");
            return card.name;
        }
    3. 상대 카드는 조종 불가능하게 구현 -> //프론트에서 구현?
*/


}
