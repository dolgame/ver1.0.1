package dolgame;

import java.sql.SQLException;
import java.util.Arrays;

public class Card extends DBConnect {

    //DB card test
    //public static void main(String[] args) {
    //    dbChecking();
    //    System.out.println(Arrays.deepToString(getCardsFromDB()));

    //}

    public static String[][] getCardsFromDB() {
        dbChecking();

        String[][] cardsArray = new String[9][7];
        String sql = "select * from cards";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            int i = 0;
            while (resultSet.next()) {
                cardsArray[i][0] = resultSet.getString(1);    //id
                cardsArray[i][1] = resultSet.getString(2);    //name
                cardsArray[i][2] = String.valueOf(resultSet.getInt(3));    //hp
                cardsArray[i][3] = String.valueOf(resultSet.getInt(4));    //atk
                cardsArray[i][4] = String.valueOf(resultSet.getInt(5));    //cost
                cardsArray[i][5] = String.valueOf(resultSet.getInt(6));    //def
                cardsArray[i][6] = resultSet.getString(7);    //impact
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("card load 성공"); //테스트용 코드
        return cardsArray;
    }

}
