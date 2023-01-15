package com.example.tpd_server.models;

import com.example.tpd_server.interfaces.UserMotorcycleInterface;

import javax.ejb.Stateless;

@Stateless
public class UserMotorcycle implements UserMotorcycleInterface {
    private int userId;
    private int motorcycleId;

    public UserMotorcycle(){

    }
    public UserMotorcycle(int userId, int motorcycleId) {
        this.userId = userId;
        this.motorcycleId = motorcycleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(int motorcycleId) {
        this.motorcycleId = motorcycleId;
    }
}
