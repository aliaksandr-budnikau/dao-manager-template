package ru.itsphere.dao;

/**
 * http://it-channel.ru/
 * <p>
 * @author Budnikov Aleksandr
 */
public interface DAOManager extends AutoCloseable {
    /**
     * Возвращает DAO для пользователей
     */
    UserDAO getUserDAO();

    /**
     * Возвращает DAO для кошельков
     */
    PurseDAO getPurseDAO();

    /**
     * Открывает транзакцию
     */
    void beginTransaction();

    /**
     * Комитит (закрывает) транзакцию
     */
    void commitTransaction();

    /**
     * Отменяет транзакцию
     */
    void rollbackTransaction();
}
