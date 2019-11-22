package com.panyang.pojo;

public class Role {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String roleName;

    /**
     * 
     */
    private Integer authId;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return role_name 
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 
     * @param roleName 
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 
     * @return auth_id 
     */
    public Integer getAuthId() {
        return authId;
    }

    /**
     * 
     * @param authId 
     */
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
}