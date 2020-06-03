package com.sg.m3carlot.dto;

import java.util.Objects;

/**
 *
 * @author naris
 */
public class CarKey {

    private String VIN;
    private boolean laserCut;

    /*ctor*/
    public CarKey(String VIN) {
        this.VIN = VIN;
    }
    
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

    /*testing*/
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.VIN);
        hash = 29 * hash + (this.laserCut ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarKey other = (CarKey) obj;
        if (this.laserCut != other.laserCut) {
            return false;
        }
        if (!Objects.equals(this.VIN, other.VIN)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CarKey{" + "VIN=" + VIN + ", laserCut=" + laserCut + '}';
    }
}
