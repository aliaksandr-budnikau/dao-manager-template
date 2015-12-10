package ru.itsphere.service;

import ru.itsphere.dao.DAOManager;
import ru.itsphere.dao.DAOManagerFactory;
import ru.itsphere.domain.User;

import java.util.List;

/**
 * Реализация UserService
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class UserServiceImpl implements UserService {
    private DAOManagerFactory daoManagerFactory;

    @Override
    public void deleteById(int id) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getPurseDAO().deleteByUserId(id);
                daoManager.getUserDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't delete user by id (%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't delete user by id (%s)", id), e);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
                daoManager.beginTransaction();
                try {
                    List<User> users = daoManager.getUserDAO().getAll();
                    daoManager.commitTransaction();
                    return users;
                } catch (Exception e) {
                    daoManager.rollbackTransaction();
                    throw new ServiceException(String.format("Can't get all users"), e);
                }
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't get all users"), e);
        }
    }

    public void setDaoManagerFactory(DAOManagerFactory daoManagerFactory) {
        this.daoManagerFactory = daoManagerFactory;
    }
}
