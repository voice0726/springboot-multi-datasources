package jp.akinori.multidb.dao.mysqlDao.impl;

import jp.akinori.multidb.dao.mysqlDao.ClientDao;
import jp.akinori.multidb.entity.User;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM client_user;").getResultList();
    }
}
