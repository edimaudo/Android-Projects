package com.edimaudo.reminders;

import java.io.Serializable;

/**
 * Created by edima on 2017-06-22.
 */

public class Reminder implements Serializable {
  private int id;
  private String ReminderTitle;
  private String ReminderTime;
  private String ReminderDate;
  private int ReminderRepeatCount;
  private String ReminderRepeatValue;
  private String ReminderLocation;

  public Reminder() {
  }

  public Reminder(int id, String reminderTitle, String reminderTime, String reminderDate, int reminderRepeatCount, String reminderRepeatValue, String reminderLocation) {
    this.id = id;
    ReminderTitle = reminderTitle;
    ReminderTime = reminderTime;
    ReminderDate = reminderDate;
    ReminderRepeatCount = reminderRepeatCount;
    ReminderRepeatValue = reminderRepeatValue;
    ReminderLocation = reminderLocation;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRemindertitle() {
    return ReminderTitle;
  }

  public void setRemindertitle(String remindertitle) {
    ReminderTitle = remindertitle;
  }

  public String getReminderTime() {
    return ReminderTime;
  }

  public void setReminderTime(String reminderTime) {
    ReminderTime = reminderTime;
  }

  public String getReminderDate() {
    return ReminderDate;
  }

  public void setReminderDate(String reminderDate) {
    ReminderDate = reminderDate;
  }

  public int getReminderRepeatCount() {
    return ReminderRepeatCount;
  }

  public void setReminderRepeatCount(int reminderRepeatCount) {
    ReminderRepeatCount = reminderRepeatCount;
  }

  public String getReminderRepeatValue() {
    return ReminderRepeatValue;
  }

  public void setReminderRepeatValue(String reminderRepeatValue) {
    ReminderRepeatValue = reminderRepeatValue;
  }

  public String getReminderLocation() {
    return ReminderLocation;
  }

  public void setReminderLocation(String reminderLocation) {
    ReminderLocation = reminderLocation;
  }
}
