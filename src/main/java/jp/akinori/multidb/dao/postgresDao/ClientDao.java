package jp.akinori.multidb.dao.postgresDao;

import jp.akinori.multidb.entity.User;

import java.util.List;

public interface ClientDao {

    List<User> findAll();
}
