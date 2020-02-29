package jp.akinori.multidb.dao.mysqlDao;

import jp.akinori.multidb.entity.User;

import java.util.List;

public interface ClientDao {

    List<User> findAll();
}
