package jp.akinori.multidb.dao.MysqlDao.impl;

import jp.akinori.multidb.dao.MysqlDao.ClientDao;
import jp.akinori.multidb.entity.primary.User;
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
