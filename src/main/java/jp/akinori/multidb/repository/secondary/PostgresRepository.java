package jp.akinori.multidb.repository.secondary;

import jp.akinori.multidb.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aha-oretama
 */
public interface PostgresRepository extends JpaRepository<User,Integer> {
}
