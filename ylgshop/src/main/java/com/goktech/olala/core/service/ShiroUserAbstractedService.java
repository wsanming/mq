package com.goktech.olala.core.service;

import com.goktech.olala.core.config.ShiroUser;

import java.util.Set;

public class ShiroUserAbstractedService {

    public ShiroUser getShiroUser(String userName){
        return null;
    }

    public Set<String> getRoles(String userName){
        return null;
    }

    public Set<String> getPermissions(String userName){
        return null;
    }
}
