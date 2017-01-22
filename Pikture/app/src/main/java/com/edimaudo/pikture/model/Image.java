package com.edimaudo.pikture.model;

import java.io.Serializable;

/**
 * Created by edima on 2017-01-21.
 */

public class Image implements Serializable {
  private String name;
  private String small, medium, large;
  private String timestamp;
  private String media;

  public Image() {
  }

  public Image(String name, String media) {
    this.name = name;
    this.media = media;

  }

  public String getMedia() {
    return media;
  }

  public void setMedia(String media) {
    this.media = media;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSmall() {
    return small;
  }

  public void setSmall(String small) {
    this.small = small;
  }

  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public String getLarge() {
    return large;
  }

  public void setLarge(String large) {
    this.large = large;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}

