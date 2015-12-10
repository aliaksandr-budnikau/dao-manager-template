package ru.itsphere.service;

import ru.itsphere.domain.Purse;

import java.util.List;

/**
 * Этот интерфейс содержит все бизнес операции связанные с классом Purse
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public interface PurseService {
    /**
     * Возвращает список всех кошельков
     *
     * @return список всех кошельков
     */
    List<Purse> getAll();


    /**
     * Возвращает список всех кошельков пользователя
     *
     * @param ownerId идентификатор пользователя
     * @return список всех кошельков пользователя
     */
    List<Purse> getAllByOwnerId(int ownerId);
}
