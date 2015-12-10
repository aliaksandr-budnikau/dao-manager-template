package ru.itsphere.dao;

import ru.itsphere.domain.Purse;

import java.util.List;

/**
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public interface PurseDAO {
    /**
     * Удаляет кошелек по userId
     *
     * @param userId
     */
    void deleteByUserId(int userId);

    /**
     * Возвращает список всех кошельков пользователя
     *
     * @param ownerId идентификатор пользователя
     */
    List<Purse> getAllByOwnerId(int ownerId);

    /**
     * Возвращает все кошельки
     */
    List<Purse> getAll();
}
