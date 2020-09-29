package com.goktech.olala.core.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

public class UuIdSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        Serializable uuid = new JavaUuidSessionIdGenerator().generateId(session);
        return uuid;
    }
}
