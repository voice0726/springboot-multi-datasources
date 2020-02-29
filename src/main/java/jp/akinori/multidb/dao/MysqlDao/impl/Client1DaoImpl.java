package jp.akinori.multidb.dao.MysqlDao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class Client1DaoImpl extends ClientDaoImpl {

    public Client1DaoImpl(@Qualifier("client1EntityManager") EntityManager entityManager) {
        super(entityManager);
    }
}
