package jp.akinori.multidb.controller;

import jp.akinori.multidb.entity.primary.User;
import jp.akinori.multidb.service.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class Controller {

    private final RestService service;

    @RequestMapping("")
    public ResponseEntity<List<User>> index() {
        List<User> userList = new ArrayList<>();

        try {
            userList.addAll(service.findAll("client1"));
            userList.addAll(service.findAll("client2"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(userList);
        }

        return ResponseEntity.ok(userList);
    }

    @RequestMapping("/{clientName}")
    @ResponseBody
    public ResponseEntity<List<User>> findInDb(@PathVariable String clientName) {
        List<User> all = new ArrayList<>();
        try {
            all = service.findAll(clientName);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.badRequest().body(all);
        }
        return ResponseEntity.ok(all);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<User>> all() {

        List<User> userList = new ArrayList<>(service.findAllFromAllDB());
        return ResponseEntity.ok(userList);
    }
}
