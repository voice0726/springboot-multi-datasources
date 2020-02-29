package jp.akinori.multidb.dao.PostgresDao;

import jp.akinori.multidb.entity.primary.User;

import java.util.List;

public interface ClientDao {

    List<User> findAll();
}
