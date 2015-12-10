package ru.itsphere.dao;

/**
 * Исключение дао слоя
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class DAOException extends RuntimeException {
    /**
     * Исключение дао слоя
     *
     * @param message текст описывающий условия при которых была ошибка
     * @param cause   причина (исключение)
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
