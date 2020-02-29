package jp.akinori.multidb.repository.primary;

import jp.akinori.multidb.entity.primary.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author akinori
 */
public interface UserRepository extends JpaRepository<User,Integer>{
}
