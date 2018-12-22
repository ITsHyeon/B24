package kr.developer.co.b24.database;

public class DBManager {
    public String getCreateMemberTable(){
        return "CREATE TABLE member("+
                "    age INTEGER," +
                "    gender INTEGER" +
                ");";
    }

    public String getCreateAdviceTable(){
        return "CREATE TABLE advice(" +
                "    advice_idx INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    member_age INTEGER," +
                "    member_gender INTEGER," +
                "    comment STRING," +
                "    likes INTEGER," +
                "    category INTEGER," +
                "    age INTEGER" +
                ");";
    }
}
