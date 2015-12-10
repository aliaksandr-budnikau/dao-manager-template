package ru.itsphere.dao;

import ru.itsphere.domain.Purse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация PurseDAO через JDBC
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class PurseDAOImpl implements PurseDAO {
    private Connection connection;

    public PurseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void deleteByUserId(int userId) {
        final String DELETE_BY_USER_ID = "DELETE FROM purses WHERE ownerId = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(String.format("Can't delete purse by user id (%s)", userId), e);
        }
    }

    @Override
    public List<Purse> getAllByOwnerId(int ownerId) {
        final String GET_ALL_BY_OWNER_ID = "SELECT * FROM purses WHERE ownerId = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_OWNER_ID)) {
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Purse> purses = new ArrayList<>();
            while (resultSet.next()) {
                Purse purse = new Purse();
                purse.setId(resultSet.getInt("id"));
                purse.setOwnerId(resultSet.getInt("ownerId"));
                purse.setName(resultSet.getString("name"));
                purse.setCurrency(resultSet.getString("currency"));
                purse.setAmount(resultSet.getBigDecimal("amount"));
                purses.add(purse);
            }
            return purses;
        } catch (Exception e) {
            throw new DAOException(String.format("Can't get all by owner id (%s)", ownerId), e);
        }
    }

    @Override
    public List<Purse> getAll() {
        final String GET_ALL_QUERY = "SELECT * FROM purses;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            List<Purse> purses = new ArrayList<>();
            while (resultSet.next()) {
                Purse purse = new Purse();
                purse.setId(resultSet.getInt("id"));
                purse.setOwnerId(resultSet.getInt("ownerId"));
                purse.setName(resultSet.getString("name"));
                purse.setCurrency(resultSet.getString("currency"));
                purse.setAmount(resultSet.getBigDecimal("amount"));
                purses.add(purse);
            }
            return purses;
        } catch (Exception e) {
            throw new DAOException(String.format("Can't get all"), e);
        }
    }
}
