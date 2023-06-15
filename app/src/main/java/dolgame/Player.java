package dolgame;

public class Player{

    Card card = new Card();
    Turn turn= new Turn();

    int health = 30;
    int cost = 1;
    void gameOver(int health){
        if(health<0){
            System.out.println("Game over");
        }
        //게임 승리 시, 졌을 시 다르게 출력 요청
    }

    int addMyMaxCost(){ //cost=1로 시작, 10이 될때까지 턴 1회당 1씩 증가
        if(turn.totalTurn <= 20){
            if(turn.totalTurn % 2 == 0){
                cost++;
            }
        }
        return cost;    //게임 턴마다 새로은 cost받기
    }
    void costCompare(){ // card의 cost를 가져와서 비교해서 내 cost가 더 클 경우 카드를 낸다
        if(cost > card.cost){
            // 카드를 내는걸 어떻게 구현함? 뭘 return 할지 알아야 할듯??
            System.out.println("card selected");

            cost = cost - card.cost;    //냈을 때 마나 차감
        }
        else{
            System.out.println("not enough cost");
        }
    }

    public static void main(String[] args) {

    }


}
