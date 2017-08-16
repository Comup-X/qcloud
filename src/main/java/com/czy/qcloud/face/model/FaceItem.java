package com.czy.qcloud.face.model;

public class FaceItem {
    private String face_id;
    private Integer x;
    private Integer y;
    private Float width;
    private Float height;
    private Integer gender;
    private Integer age;
    private Integer expression;
    private Boolean glass;
    private Integer pitch;
    private Integer yaw;
    private Integer roll;

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExpression() {
        return expression;
    }

    public void setExpression(Integer expression) {
        this.expression = expression;
    }

    public Boolean getGlass() {
        return glass;
    }

    public void setGlass(Boolean glass) {
        this.glass = glass;
    }

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public Integer getYaw() {
        return yaw;
    }

    public void setYaw(Integer yaw) {
        this.yaw = yaw;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }
}
