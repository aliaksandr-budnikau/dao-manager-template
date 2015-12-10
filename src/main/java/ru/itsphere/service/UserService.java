package ru.itsphere.service;

import ru.itsphere.domain.User;

import java.util.List;

/**
 * http://it-channel.ru/
 * <p>
 *
 * @author Budnikov Aleksandr
 */
public interface UserService {
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
