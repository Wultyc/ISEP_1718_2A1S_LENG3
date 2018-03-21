/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel
 */
public class CoordGPS {
    private double latitude;
    private double longitude;
    private double altitude;

    public CoordGPS(){
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
    }
    
    public CoordGPS(double latitude, double longitude, double altitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }
    

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return this.latitude + "; " + this.longitude + "; " + this.altitude;
    }
}
