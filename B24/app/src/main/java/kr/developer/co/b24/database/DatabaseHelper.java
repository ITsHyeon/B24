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
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + "member");
    onCreate(db);
  }

  public void insertMemberData(Member member) {
    deleteMemberData();

    final SQLiteDatabase db = this.getWritableDatabase();

    String sql = "INSERT OR REPLACE INTO member VALUES(?,?)";

    final SQLiteStatement insertStmt = db.compileStatement(sql);

    insertStmt.clearBindings();

    insertStmt.bindLong(1, member.getAge());
    insertStmt.bindLong(2, member.getGender() ? 0 : 1);

    insertStmt.executeInsert();
  }

  private Member getMemberData() {
    final Member member = new Member();

    final SQLiteDatabase db = this.getWritableDatabase();
    final Cursor res = db.rawQuery("SELECT * FROM member", null);

    while (res.moveToNext()) {

      member.setAge(res.getInt(res.getColumnIndex("age")));
      member.setGender((res.getInt(res.getColumnIndex("gander")) == 0));
    }

    res.close();

    return member;
  }

  private void deleteMemberData() {
    final SQLiteDatabase db = this.getWritableDatabase();

    String sql = "DELETE FROM member";

    db.execSQL(sql);
  }
}
