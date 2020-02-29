package jp.akinori.multidb.dao.mysqlDao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class Client2DaoImpl extends ClientDaoImpl {

    public Client2DaoImpl(@Qualifier("client2EntityManager") EntityManager entityManager) {
        super(entityManager);
    }
}
