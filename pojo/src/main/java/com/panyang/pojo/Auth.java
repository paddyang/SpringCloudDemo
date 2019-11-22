package com.panyang.pojo;

public class Auth {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String desc;

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
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return desc 
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc 
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}