package com.smhrd.j.android;


import com.android.volley.Response;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Login_POST extends Login_contract {

    private  final  static  String URL= "http://222.102.104.135:3000/Join.php";
    private Map<String, String> map;

    public Login_POST(String id, String pw, String name, String n_name,
                      String h_p, String email, String add, int year, int month, int day,
                      Response.Listener<String>listener){

//        super(Method.PUBLIC,URL,listener,null);

        map=new HashMap<>();
        map.put("userID", id);
        map.put("userPW", pw);

    };

}