package com.example.roomwordsample;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
@Entity(tableName = "word_table")
public class Word {
  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "word")
  private String mWord;
  public Word(@NonNull String word) {this.mWord = word;}
  public String getWord(){return this.mWord;}
}
