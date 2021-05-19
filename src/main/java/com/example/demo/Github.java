package com.example.demo;

public class Github {
   private String client_id = "5d8cecb4786f22ad30eb";
   private String client_secret = "8900d0b339137288ed8e250534b328d6c4812c0e";
   private String redirect_uri = "http://localhost:8080/callback";

   public String getLogin() {
      return "https://github.com/login/oauth/authorize?&client_id="+client_id+"&scope=user&redirect_uri="+redirect_uri;
   }

   public String getClient_id() {
      return client_id;
   }

   public String getClient_secret() {
      return client_secret;
   }

   public String getUrlForAccesToken(String code) {
      return "https://github.com/login/oauth/access_token?&client_id="+client_id+"&client_secret="+client_secret+"&code="+code;
   }
}
