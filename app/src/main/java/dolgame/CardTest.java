package dolgame;

import java.sql.SQLException;

public class CardTest extends DBConnect{
    String id;
    String name;
    String hp;
    String atk;
    String cost;
    String def;
    String impact;

    public CardTest(int i){

        String sql = "select * from cards where id ="+i;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                this.id = resultSet.getString(1);    //id
                this.name = resultSet.getString(2);    //name
                this.hp = String.valueOf(resultSet.getInt(3));    //hp
                this.atk = String.valueOf(resultSet.getInt(4));    //atk
                this.cost = String.valueOf(resultSet.getInt(5));    //cost
                this.def = String.valueOf(resultSet.getInt(6));    //def
                this.impact = resultSet.getString(7);    //impact
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }


}
