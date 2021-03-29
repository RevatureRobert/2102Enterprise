package com.db;

import java.util.HashMap;

public class SQLHashMap {
    private static HashMap<String, String> sqlconversion = new HashMap<>();
    static{
        sqlconversion.put("int", "integer");
        sqlconversion.put("boolean", "boolean");
        sqlconversion.put("short", "smallint");
        sqlconversion.put("long", "bigint");
        sqlconversion.put("char", "char");
        sqlconversion.put("float", "float");
        sqlconversion.put("double", "double precision");
        sqlconversion.put("byte", "smallint");
        sqlconversion.put("java.lang.String", "text");
        sqlconversion.put("java.lang.Boolean", "boolean");
        sqlconversion.put("java.lang.Byte", "smallint");
        sqlconversion.put("java.lang.Short", "smallint");
        sqlconversion.put("java.lang.Long", "bigint");
        sqlconversion.put("java.lang.Double", "double precision");
        sqlconversion.put("java.lang.Character", "char");
        sqlconversion.put("java.lang.Integer", "integer");
        sqlconversion.put("java.lang.Float", "float");
    }

    public HashMap<String, String> getSQLHashMap(){
        return sqlconversion;
    }

}
