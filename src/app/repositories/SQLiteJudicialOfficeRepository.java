package app.repositories;

import app.database.DBConnection;
import app.exceptions.DataAccessException;
import app.models.metadata.JudicialOffice;
import app.models.metadata.Location;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.val;

public class SQLiteJudicialOfficeRepository implements JudicialOfficeRepository {

    private final DBConnection connection;

    public SQLiteJudicialOfficeRepository(DBConnection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(JudicialOffice data) throws DataAccessException, SQLException {
        val query =
            "INSERT INTO judicial_offices (code, name, department, city, category) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, data.getCode() + "");
        statement.setString(2, data.getName());
        statement.setString(3, data.getLocation().getDepartment());
        statement.setString(4, data.getLocation().getCity());
        statement.setString(5, data.getCategory());
        statement.executeQuery();
    }

    @Override
    public List<JudicialOffice> getAll() throws DataAccessException, SQLException {
        val query = "SELECT * FROM judicial_offices";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        val judicialOffices = new ArrayList<JudicialOffice>();
        while (resultSet.next()) {
            judicialOffices.add(mapResultSetToJudicialOffice(resultSet));
        }

        return judicialOffices;
    }

    @Override
    public JudicialOffice getById(Integer id) throws DataAccessException, SQLException {
        val query = "SELECT * FROM judicial_offices WHERE code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id.toString());
        return mapResultSetToJudicialOffice(preparedStatement.executeQuery());
    }

    @Override
    public boolean updateById(Integer id, JudicialOffice newData)
        throws DataAccessException, SQLException {
        val query =
            "UPDATE judicial_offices SET name = ?, department = ?, city = ?, category = ? WHERE code = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newData.getName());
        statement.setString(2, newData.getLocation().getDepartment());
        statement.setString(3, newData.getLocation().getCity());
        statement.setString(4, newData.getCategory());
        statement.setString(5, id.toString());
        statement.executeUpdate();
        return true;
    }

    @Override
    public boolean deleteById(Integer id) throws DataAccessException, SQLException {
        val query = "SELECT FROM judicial_offices WHERE code = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, id.toString());
        return statement.execute();
    }

    private JudicialOffice mapResultSetToJudicialOffice(ResultSet resultSet)
        throws SQLException {
        int code = Integer.parseInt(resultSet.getString("code").trim());
        String name = resultSet.getString("name");
        String department = resultSet.getString("department");
        String city = resultSet.getString("city");
        String category = resultSet.getString("category");

        val location = new Location(department, city);
        return new JudicialOffice(name, code, location, category);
    }
}
