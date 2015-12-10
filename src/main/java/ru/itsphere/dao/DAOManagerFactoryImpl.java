package ru.itsphere.dao;

import javax.sql.DataSource;

/**
 * http://it-channel.ru/
 * <p>
 * @author Budnikov Aleksandr
 */
public class DAOManagerFactoryImpl implements DAOManagerFactory {

    private DataSource dataSource;

    @Override
    public DAOManager getDAOManager() {
        try {
            return new DAOManagerImpl(dataSource.getConnection());
        } catch (Exception e) {
            throw new DAOException(String.format("Can't get DAO Manager"), e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
