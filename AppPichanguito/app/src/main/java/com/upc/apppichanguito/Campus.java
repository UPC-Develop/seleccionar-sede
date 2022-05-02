package com.upc.apppichanguito;

public class Campus {
    private String campusid;
    private String name;
    private String district;
    private String direction;
    private String coordx;
    private String coordy;

    public Campus(String campusid, String name, String district, String direction, String coordx, String coordy) {
        this.campusid = campusid;
        this.name = name;
        this.district = district;
        this.direction = direction;
        this.coordx = coordx;
        this.coordy = coordy;
    }

    public Campus() {
    }

    public String getCampusid() {
        return campusid;
    }

    public void setCampusid(String campusid) {
        this.campusid = campusid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCoordx() {
        return coordx;
    }

    public void setCoordx(String coordx) {
        this.coordx = coordx;
    }

    public String getCoordy() {
        return coordy;
    }

    public void setCoordy(String coordy) {
        this.coordy = coordy;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusid='" + campusid + '\'' +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", direction='" + direction + '\'' +
                ", coordx='" + coordx + '\'' +
                ", coordy='" + coordy + '\'' +
                '}';
    }





}
