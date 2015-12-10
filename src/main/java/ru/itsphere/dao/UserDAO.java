package ru.itsphere.dao;

import ru.itsphere.domain.User;

import java.util.List;

/**
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public interface UserDAO {
    /**
     * Удаляет пользователя по идентификатору
     *
     * @param id идентификатор
     */
    void deleteById(int id);

    /**
     * Возвращает список всех пользователей
     *
     * @return список всех пользователей
     */
    List<User> getAll();
}
