package com.example.a18_18033661_phamkientrung.Entity;

import java.io.Serializable;

public class Burger implements Serializable {
    private String ten;
    private double gia;
    private int hinh;
    private float danhgia;
    private int soLuong;

    public Burger(String ten, double gia, int soLuong) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public Burger(String ten, double gia, int hinh, float danhgia) {
        this.ten = ten;
        this.gia = gia;
        this.hinh = hinh;
        this.danhgia = danhgia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public float getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(float danhgia) {
        this.danhgia = danhgia;
    }
}
