package com.example.tpd_server.interfaces;

import javax.ejb.Local;

@Local
public interface UserMotorcycleInterface {
    int getUserId();
    void setUserId(int userId);
    int getMotorcycleId();
    void setMotorcycleId(int motorcycleId);
}
