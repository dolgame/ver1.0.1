package dolgame;

public class Player {
    int health=30;
    void gameOver(int health){
        if(health<0){
            System.out.println("게임이 끝났습니다.");
        }
    }
}
