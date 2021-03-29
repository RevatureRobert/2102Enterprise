package com.model;

public class DBColumn {

    private String name;
    private String type;
    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DBColumn(String name, String type){
        this.name = name;
        this.type = type;
    }

    public DBColumn(String name, String type, String reference){
        this.name = name;
        this.type = type;
        this.reference = reference;
    }


}
