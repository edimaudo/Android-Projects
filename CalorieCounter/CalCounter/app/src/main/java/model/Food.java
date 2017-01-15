package model;

import java.io.Serializable;

/**
 * Created by paulodichone on 2/28/15.
 */
public class Food implements Serializable {
    private static final long serialVersionUID = 10L;
    private String foodName;
    private int calories;
    private int foodId;
    private String recordDate;

    public Food( String food, int cals, int id, String date){
        foodName = food;
        calories = cals;
        foodId = id;
        recordDate = date;

    }

    public Food(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
}
