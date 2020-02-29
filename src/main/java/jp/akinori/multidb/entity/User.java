package jp.akinori.multidb.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author aha-oretama
 */
@Entity
@Data
@Table(name = "client_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
}
