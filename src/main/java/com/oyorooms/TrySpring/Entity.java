package com.oyorooms.TrySpring;

import javax.persistence.Id;

@javax.persistence.Entity
public class Entity {

    @Id
    private Integer id;

    private String keyString;

    private Integer keyInteger;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyString() {
        return keyString;
    }

    public void setKeyString(String keyString) {
        this.keyString = keyString;
    }

    public Integer getKeyInteger() {
        return keyInteger;
    }

    public void setKeyInteger(Integer keyInteger) {
        this.keyInteger = keyInteger;
    }
}
