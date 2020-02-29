package jp.akinori.multidb.service;

import jp.akinori.multidb.dao.mysqlDao.ClientDao;
import jp.akinori.multidb.entity.User;
import jp.akinori.multidb.repository.secondary.PostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestService {
    private final Map<String, ClientDao> repositories;
    private final PostgresRepository postgresRepository;

    public List<User> findAll(String dbName) throws ClassNotFoundException {
        ClientDao repository = repositories.getOrDefault(dbName + "DaoImpl", null);
        if (repository == null) {
            throw new ClassNotFoundException("Specified client is not found.");
        }
        return repository.findAll();
    }

    public List<User> findAllFromAllDB() {
        List<User> result = new ArrayList<>();

        ClientDao repository1 = repositories.get("client1DaoImpl");
        ClientDao repository2 = repositories.get("client2DaoImpl");

        result.addAll(repository1.findAll());
        result.addAll(repository2.findAll());

        result.addAll(postgresRepository.findAll());

        return result;

    }

}
