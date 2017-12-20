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
    private float latitude;
    private float longitude;
    private float altitude;

    public CoordGPS(){
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
    }
    
    public CoordGPS(int latitude, int longitude, int altitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }
    

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }


    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return this.latitude + "; " + this.longitude + "; " + this.altitude;
    }
}
