package com.formationSpring.accounts.security;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class Session {
    private String account_name="ACCOUNTS_MS";
    Random rand = new Random();

    public Session(){

    }
    public String getAccount_name(){
        return  account_name+ rand.nextInt(1000);
    };

}
