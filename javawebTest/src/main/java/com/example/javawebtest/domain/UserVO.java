package com.example.javawebtest.domain;

public class UserVO {
    private String username;
    private Integer code;
    private String description="";


    public UserVO() {
    }

    public UserVO(String username, Integer code, String description) {
        this.username = username;
        this.code = code;
        this.description = description;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "UserVO{username = " + username + ", code = " + code + ", description = " + description + "}";
    }
}
