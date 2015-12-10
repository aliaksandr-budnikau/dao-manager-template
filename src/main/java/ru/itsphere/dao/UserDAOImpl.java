package ru.itsphere.dao;

import ru.itsphere.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация UserDAO через JDBC
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM users WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(String.format("Can't delete user by id (%s)", id), e);
        }
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw new DAOException(String.format("Can't get all users"), e);
        }
    }
}
