package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/api")
    public List<User> users() {
        return userDao.findAll();
    }

    @GetMapping("/callback")
    public ResponseEntity<GithubUser> login(@RequestParam String code) {
        RestTemplate restTemplate = new RestTemplate();
        Github github = new Github();

        String url = github.getUrlForAccesToken(code);
        github = restTemplate.getForObject(url, Github.class);

        System.out.println(github.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(github.getAccess_token());

        GithubUser githubUser = new GithubUser();
        HttpEntity<GithubUser> entity = new HttpEntity<>(githubUser, headers);
        String url2 = "https://api.github.com/user";
        ResponseEntity<GithubUser> githubUserResponseEntity = restTemplate.exchange(url2, HttpMethod.GET, entity, GithubUser.class);

        return githubUserResponseEntity;

    }
}
