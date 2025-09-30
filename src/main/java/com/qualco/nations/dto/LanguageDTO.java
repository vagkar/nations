package com.qualco.nations.dto;

import java.io.Serializable;

public class LanguageDTO implements Serializable {
    Integer id;
    String name;
    boolean official;

    public LanguageDTO(Integer id, String name, boolean official) {
        this.id = id;
        this.name = name;
        this.official = official;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }
}
