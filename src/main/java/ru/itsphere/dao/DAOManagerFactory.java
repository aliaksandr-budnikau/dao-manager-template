package ru.itsphere.dao;

/**
 * http://it-channel.ru/
 * <p>
 * @author Budnikov Aleksandr
 */
public interface DAOManagerFactory {
    /**
     * Возвращает DAO менеджер
     */
    DAOManager getDAOManager();
}
