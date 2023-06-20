package dolgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {

    //카드 덱
    private final String[][] cardsArray = Card.getCardsFromDB();
    private String[][] computerCardsArray = random(cardsArray);
    private String[][] playerCardsArray = random(cardsArray);
    private final String[] finalArray = new String[2];


    private final String[][] setCardArray = new String[2][6];
    String playerSelectCardName;
    String computerSelectCardName;


    //UI에서 1차원 배열 받아가기
    public String[] getComputerFieldArray() {
        return getStrings(computerCardsArray, "c");
    }

    public String[] getPlayerFieldArray() {
        return getStrings(playerCardsArray, "p");
    }

    private String[] getStrings(String[][] cardsArray, String player) {
        String[] fieldArray = new String[cardsArray.length];

        for (int i = 0; i < cardsArray.length; i++) {
            fieldArray[i] = player + "\n";

            for (int j = 1; j < cardsArray[i].length - 1; j++) {
                if (j < cardsArray[i].length - 2)
                    fieldArray[i] += cardsArray[i][j] + "\n";
                else fieldArray[i] += cardsArray[i][j];
            }
        }

        return fieldArray;
    }

    public String[][] random(String[][] array) {
        String[][] shuffledArray = array.clone();

        int cardCount = shuffledArray.length;
        for (int i = 0; i < cardCount; i++) {
            int r = i + (int) (Math.random() * (cardCount - i));
            String[] tmp = shuffledArray[r];
            shuffledArray[r] = shuffledArray[i];
            shuffledArray[i] = tmp;
        }

        return shuffledArray;
    }

    public String[] attack(String cardText) {

        String[][] cardArray;
        if (selectCard(cardText) == null) return null;
        else cardArray = selectCard(cardText);

        System.out.println("player 선택 카드: " + Arrays.toString(setCardArray[0]));
        System.out.println("computer 선택 카드: " + Arrays.toString(setCardArray[1]));

        playerSelectCardName = cardArray[0][1];
        computerSelectCardName = cardArray[1][1];
        if (playerSelectCardName == null || computerSelectCardName == null) {
            return null;
        }
        int computerSelectedCardIndex = 0;
        int playerSelectedCardIndex = 0;

        //본인 카드 배열에서 선택된 카드 찾기
        for (int i = 0; i < computerCardsArray.length; i++) {
            if (playerCardsArray[i][1].equals(playerSelectCardName)) {
                playerSelectedCardIndex = i;
            }

            if (computerCardsArray[i][1].equals(computerSelectCardName)) {
                computerSelectedCardIndex = i;
            }
        }

        int playerSelectedCardHealth = Integer.parseInt(playerCardsArray[playerSelectedCardIndex][2]);
        int playerSelectedCardAtk = Integer.parseInt(playerCardsArray[playerSelectedCardIndex][3]);
        int computerSelectedCardHealth = Integer.parseInt(computerCardsArray[computerSelectedCardIndex][2]);
        int computerSelectedCardAtk = Integer.parseInt(computerCardsArray[computerSelectedCardIndex][3]);

        System.out.println(playerSelectCardName + "가 " + computerSelectCardName + "을 공격하였습니다!");
        System.out.println(computerSelectCardName + "가 " + playerSelectedCardAtk + "만큼의 피해를 입었습니다!");
        System.out.println(playerSelectCardName + "가 " + computerSelectedCardAtk + "만큼의 피해를 입었습니다!");

        //방어 카드의 남은 피가 0 이하일 때
        if (computerSelectedCardHealth - playerSelectedCardAtk <= 0) {
            computerRemoveCard(computerSelectedCardIndex);
            System.out.println(computerSelectCardName + "가 사망하였습니다.");
            finalArray[1] = null;
        }

        //공격 카드의 남은 피가 0 이하일 때
        if (playerSelectedCardHealth - computerSelectedCardAtk <= 0) {
            //배열에서 없애고 빈칸 채우기
            playerRemoveCard(playerSelectedCardIndex);
            System.out.println(playerSelectCardName + "가 사망하였습니다.");
            finalArray[0] = null;
        }

        //방어 카드의 남은 피가 1 이상일 때
        if (computerSelectedCardHealth - playerSelectedCardAtk > 0) {
            computerCardsArray[computerSelectedCardIndex][2] = String.valueOf(computerSelectedCardHealth - playerSelectedCardAtk);
            System.out.println(computerSelectCardName + "의 남은 체력: " + (computerSelectedCardHealth - playerSelectedCardAtk));

            for (int i = 0; i < computerCardsArray[computerSelectedCardIndex].length; i++) {
                if (i != computerCardsArray[computerSelectedCardIndex].length - 1) {
                    finalArray[1] += computerCardsArray[computerSelectedCardIndex][i] + "\n";
                } else {
                    finalArray[1] += computerCardsArray[computerSelectedCardIndex][i];
                }
            }
        }

        //공격 카드의 남은 피가 1 이상일 때
        if (playerSelectedCardHealth - computerSelectedCardAtk > 0) {
            playerCardsArray[playerSelectedCardIndex][2] = String.valueOf(playerSelectedCardHealth - computerSelectedCardAtk);
            System.out.println(playerSelectCardName + "의 남은 체력: " + (playerSelectedCardHealth - computerSelectedCardAtk));

            for (int i = 0; i < computerCardsArray[playerSelectedCardIndex].length; i++) {
                if (i != playerCardsArray[playerSelectedCardIndex].length - 1) {
                    finalArray[1] += playerCardsArray[playerSelectedCardIndex][i] + "\n";
                } else {
                    finalArray[1] += playerCardsArray[playerSelectedCardIndex][i];
                }
            }
        }

        init(setCardArray);
        System.out.println(Arrays.deepToString(playerCardsArray));
        System.out.println(Arrays.deepToString(computerCardsArray));
        if (finalArray[0] != null && finalArray[1] != null) {
            return finalArray;

        } else return null;
    }

    private void init(String[][] setCardArray) {
        for (int i = 0; i < setCardArray.length; i++) {
            Arrays.fill(setCardArray[i], null);
        }

        playerSelectCardName = null;
        computerSelectCardName = null;
    }

    public String[][] selectCard(String cardText) {

        if (cardText.split("\n")[0].equals("p")) {
            for (int i = 0; i < cardText.split("\n").length; i++) {
                setCardArray[0][i] = cardText.split("\n")[i];
            }
        } else if (cardText.split("\n")[0].equals("c") && setCardArray[0][0] == null) {
            System.out.println("공격할 나의 카드를 먼저 선택하세요.");
            return null;
        } else {
            for (int i = 0; i < cardText.split("\n").length; i++) {
                setCardArray[1][i] = cardText.split("\n")[i];
            }
        }

        return setCardArray;
    }

    public void playerRemoveCard(int removeArrayIndex) {

        List<List<String>> list = new ArrayList<>();

        //배열 -> 리스트
        for (String[] row : playerCardsArray) {
            List<String> innerList = new ArrayList<>();
            for (String element : row) {
                innerList.add(element);
            }
            list.add(innerList);
        }

        //remove
        list.remove(removeArrayIndex);

        //리스트 -> 배열
        playerCardsArray = new String[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);
            playerCardsArray[i] = new String[row.size()];
            for (int j = 0; j < row.size(); j++) {
                playerCardsArray[i][j] = row.get(j);
            }
        }
    }

    public void computerRemoveCard(int removeArrayIndex) {

        List<List<String>> list = new ArrayList<>();

        //배열 -> 리스트
        for (String[] row : computerCardsArray) {
            List<String> innerList = new ArrayList<>();
            for (String element : row) {
                innerList.add(element);
            }
            list.add(innerList);
        }

        //remove
        list.remove(removeArrayIndex);

        //리스트 -> 배열
        computerCardsArray = new String[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);
            computerCardsArray[i] = new String[row.size()];
            for (int j = 0; j < row.size(); j++) {
                computerCardsArray[i][j] = row.get(j);
            }
        }
    }
}
