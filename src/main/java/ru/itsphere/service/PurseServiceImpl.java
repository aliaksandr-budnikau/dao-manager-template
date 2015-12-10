package ru.itsphere.service;

import ru.itsphere.dao.DAOManager;
import ru.itsphere.domain.Purse;
import ru.itsphere.dao.DAOManagerFactory;

import java.util.List;

/**
 * Реализация PurseService
 * <p>
 * http://it-channel.ru/
 *
 * @author Budnikov Aleksandr
 */
public class PurseServiceImpl implements PurseService {
    private DAOManagerFactory daoManagerFactory;

    @Override
    public List<Purse> getAll() {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Purse> purses = daoManager.getPurseDAO().getAll();
                daoManager.commitTransaction();
                return purses;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't get all"), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't get all"), e);
        }
    }

    @Override
    public List<Purse> getAllByOwnerId(int ownerId) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Purse> purses = daoManager.getPurseDAO().getAllByOwnerId(ownerId);
                daoManager.commitTransaction();
                return purses;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't get all by owner id (%s)", ownerId), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't get all by owner id (%s)", ownerId), e);
        }
    }

    public void setDaoManagerFactory(DAOManagerFactory daoManagerFactory) {
        this.daoManagerFactory = daoManagerFactory;
    }
}
