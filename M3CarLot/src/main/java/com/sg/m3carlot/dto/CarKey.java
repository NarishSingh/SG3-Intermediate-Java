package com.sg.m3carlot.dto;

/**
 *
 * @author naris
 */
public class CarKey {

    private String VIN;
    private boolean laserCut;

    /*getter/setters*/
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public boolean isLaserCut() {
        return laserCut;
    }

    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }

}
