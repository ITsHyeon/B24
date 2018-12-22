package kr.developer.co.b24.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.media.MediaMetadata;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kr.developer.co.b24.model.Advice;
import kr.developer.co.b24.model.Member;

public final class DatabaseHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "B24.db";
  @Nullable private static DatabaseHelper databaseHelper = null;
  private final DBManager dbManager = new DBManager();

  private DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, 1);
  }

  @NonNull
  public static DatabaseHelper getDatabaseHelper(Context context) {
    if (databaseHelper == null) {
      databaseHelper = new DatabaseHelper(context);
      return databaseHelper;
    } else {
      return databaseHelper;
    }
  }

  @Nullable
  public static DatabaseHelper getDatabaseHelper() {
    return databaseHelper;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("PRAGMA foreign_keys = ON;");
    db.execSQL(dbManager.getCreateMemberTable());
    db.execSQL(dbManager.getCreateAdviceTable());
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + "member");
    db.execSQL("DROP TABLE IF EXISTS " + "advice");
    onCreate(db);
  }

  public void insertMemberData(Member member) {
    if (getMemberData() != null){
      deleteMemberData();
    }

    final SQLiteDatabase db = this.getWritableDatabase();

    String sql = "INSERT OR REPLACE INTO member VALUES(?,?)";

    final SQLiteStatement insertStmt = db.compileStatement(sql);

    insertStmt.clearBindings();

    insertStmt.bindLong(1, member.getAge());
    insertStmt.bindLong(2, member.getGender() ? 0 : 1);

    insertStmt.executeInsert();
  }

  public Member getMemberData() {
    final Member member = new Member();

    final SQLiteDatabase db = this.getWritableDatabase();
    final Cursor res = db.rawQuery("SELECT * FROM member", null);

    while (res.moveToNext()) {
      member.setAge(res.getInt(res.getColumnIndex("age")));
      member.setGender((res.getInt(res.getColumnIndex("gender")) == 0));
    }

    res.close();

    return member;
  }

  private void deleteMemberData() {
    final SQLiteDatabase db = this.getWritableDatabase();

    String sql = "DELETE FROM member";

    db.execSQL(sql);
  }


  public void insertAdviceData(Advice advice) {
    final SQLiteDatabase db = this.getWritableDatabase();

    String sql = "INSERT OR REPLACE INTO advice VALUES(?,?,?,?,?,?,?)";

    final SQLiteStatement insertStmt = db.compileStatement(sql);

    insertStmt.clearBindings();

    insertStmt.bindLong(1, advice.getIdx());
    insertStmt.bindLong(2, advice.getMember().getAge());
    insertStmt.bindLong(3, advice.getMember().getGender() ? 0:1);
    insertStmt.bindString(4, advice.getComment());
    insertStmt.bindLong(5, advice.getLikeCount());
    insertStmt.bindLong(6, advice.getCategory());
    insertStmt.bindLong(7, advice.getAge());

    insertStmt.executeInsert();
  }

  public List<Advice> getAdviceList(int age) {
    List<Advice> adviceList = new ArrayList<>();
    final SQLiteDatabase db = this.getWritableDatabase();
    final Cursor res = db.rawQuery("SELECT * FROM advice WHERE age >=" + age, null);

    while (res.moveToNext()) {
      final Advice advice = new Advice();

      advice.setIdx(res.getInt(res.getColumnIndex("advice_idx")));

      advice.setMember(new Member(
              res.getInt(res.getColumnIndex("member_age")),
              (res.getInt(res.getColumnIndex("member_gender")) == 0)
      ));

      advice.setComment(res.getString(res.getColumnIndex("comment")));
      advice.setLikeCount(res.getInt(res.getColumnIndex("likes")));
      advice.setCategory(res.getInt(res.getColumnIndex("category")));
      advice.setAge(res.getInt(res.getColumnIndex("age")));

      adviceList.add(advice);
    }

    res.close();

    return adviceList;
  }

  public int getLastAdviceIdx() {
      final SQLiteDatabase db = this.getWritableDatabase();
      final Cursor res = db.rawQuery("SELECT advice_idx FROM advice ORDER BY advice_idx DESC LIMIT 1", null);
      Advice advice = new Advice();

      while (res.moveToNext()) {
        advice.setIdx(res.getInt(res.getColumnIndex("advice_idx")));
      }

      res.close();

      return advice.getIdx()+1;
  }
}