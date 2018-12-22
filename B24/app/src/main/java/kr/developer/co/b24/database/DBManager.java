package kr.developer.co.b24.database;

public class DBManager {
    public String getCreateMemberTable(){
        return "create table member(" +
                "    age INTEGER," +
                "    gender INTEGER" +
                ");";
    }
}
