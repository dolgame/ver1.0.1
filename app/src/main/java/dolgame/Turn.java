package dolgame;

//public class Turn {
//    enum GamePlayer{COMPUTER, PLAYER}
//    private GamePlayer player;
//    int totalTurn = 0;
//    void turn(){ // 턴을 변경하고, totalTurn을 +1한다
//        if(player == GamePlayer.COMPUTER){
//            player = GamePlayer.PLAYER;
//        }else {
//            player = GamePlayer.COMPUTER;
//        }
//        totalTurn++;
//    }
//}
public class Turn {
    public static String player = "computer";

    int totalTurn = 0;
    String turn(){ // 턴을 변경하고, totalTurn을 +1한다
        if(player.equals("computer")){
            player = "user";
        }else {
            player = "computer";
        }
        totalTurn++;
        return player;
    }


}