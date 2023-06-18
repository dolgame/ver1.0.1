package dolgame;

import java.util.ArrayList;

public class Player{
    Turn turn= new Turn();

    ArrayList<CardTest> cardsInHand = new ArrayList<>();
    int health = 30;
    int cost = 1;

    void gameOver(int health){
        if(turn.player == Turn.GamePlayer.COMPUTER){
            if(health<0){
                System.out.println("Player win");
            }
        }else{
            System.out.println("Player loose");
        }


    }

    int addMyMaxCost(){ //cost=1로 시작, cost=10이 될때까지 턴 1회당 1씩 증가
        if(turn.totalTurn <= 20){
            if(turn.totalTurn % 2 == 0){
                cost++;
            }
        }
        return cost;    //게임 턴마다 새로은 cost받기
    }

    void costCompare(CardTest c1){ // card의 cost를 가져와서 비교해서 내 cost가 더 클 경우 카드를 낸다
        int cardCost = Integer.parseInt(c1.cost);
        if(cost > cardCost){
            // 카드를 내는걸 어떻게 구현함? 뭘 return 할지 알아야 할듯??
            System.out.println("card selected");

            cost = cost - cardCost;    //냈을 때 마나 차감
        }
        else{
            System.out.println("not enough cost");
        }
    }
    void getCard(CardTest c){
        cardsInHand.add(c);
    }
    void showPlayerCard(){
        for(CardTest c : cardsInHand){
            System.out.println("name : " + c.name + "hp : " + c.hp +
                    "atk : " +  c.atk + "cost : " + c.cost +
                    "def : " + c.def + "impact : " + c.impact);
        }
    }
}
