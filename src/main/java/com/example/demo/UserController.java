package com.example.demo;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api")
    public List<User> users() {
        return userDao.findAll();
    }

    @GetMapping("/callback")
    public String login(@RequestParam String code) {
        Github github = new Github();

        String url = github.getUrlForAccesToken(code);
        Object object = restTemplate.getForObject(url, Object.class);
        String jsonInString = new Gson().toJson(object);
        JSONObject jsonObject = new JSONObject(jsonInString);

        String accessToken = jsonObject.getString("access_token");

        return "액세스토큰: "+ accessToken;
    }
}
