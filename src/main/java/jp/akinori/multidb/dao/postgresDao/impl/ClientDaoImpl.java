package jp.akinori.multidb.dao.postgresDao.impl;

import jp.akinori.multidb.dao.postgresDao.ClientDao;
import jp.akinori.multidb.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class ClientDaoImpl implements ClientDao {

    @Qualifier("secondaryEntityManager")
    private final EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM client_user;").getResultList();
    }
}
