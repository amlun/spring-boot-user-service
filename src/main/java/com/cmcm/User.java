package com.cmcm;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("users")
public class User implements Serializable {
    @PrimaryKey
    private String openid;

    private String nickname;

    private String avatar;

    public User() {

    }

    public User(String openid, String nickname, String avatar) {
        this.openid = openid;
        this.nickname = nickname;
        this.avatar = avatar;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
