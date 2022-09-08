package pl.emjos.homebudget.budget;

import pl.emjos.homebudget.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BudgeteItemDao {
    private final DataSource dataSource;

    public BudgeteItemDao( ) {
        try{
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
    public void save (BudgetItem budgeteItem)
    {
        String sql = "INSERT INTO budget_item(description,value,type) VALUES(?,?,?)";

        try(Connection connection = dataSource.getConnection();)
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,budgeteItem.getDescription());
            statement.setBigDecimal(2,budgeteItem.getValue());
            statement.setString(3,budgeteItem.getType().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public List<BudgetItem> findAll(BudgetItemType type)
        {
            String sql = "SELECT description,value,type FROM budget_item WHERE type =?";
            List<BudgetItem> budgetItemList = new ArrayList<>();
            try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql))
            {
                preparedStatement.setString(1,type.name());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    String description = resultSet.getString("description");
                    BigDecimal itemValue = resultSet.getBigDecimal("value");
                    String itemType = resultSet.getString("type");

                    budgetItemList.add(new BudgetItem(description,itemValue,BudgetItemType.valueOf(itemType)));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return budgetItemList;
        }



}
