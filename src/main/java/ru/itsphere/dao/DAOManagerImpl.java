package ru.itsphere.dao;

import java.sql.Connection;

/**
 * http://it-channel.ru/
 * <p>
 * @author Budnikov Aleksandr
 */
public class DAOManagerImpl implements DAOManager {
    private Connection connection;

    private UserDAO userDAO;
    private PurseDAO purseDAO;

    public DAOManagerImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl(getConnection());
        }
        return userDAO;
    }

    public PurseDAO getPurseDAO() {
        if (purseDAO == null) {
            purseDAO = new PurseDAOImpl(getConnection());
        }
        return purseDAO;
    }

    @Override
    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new DAOException(String.format("Can't begin transaction"), e);
        }
    }

    @Override
    public void commitTransaction() {
        try {
            getConnection().commit();
        } catch (Exception e) {
            throw new DAOException(String.format("Can't commit transaction"), e);
        }
    }

    @Override
    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (Exception e) {
            throw new DAOException(String.format("Can't rollback transaction"), e);
        }
    }

    @Override
    public void close() {
        if (getConnection() != null) {
            try {
                getConnection().close();
            } catch (Exception e) {
                throw new DAOException(String.format("Can't close connection"), e);
            }
        }
    }

    private Connection getConnection() {
        return connection;
    }
}
