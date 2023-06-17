package com.example.tpd_server.controllers;

import com.example.tpd_server.services.ThirdPartyService;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import jakarta.ws.rs.*;

import java.io.IOException;

@Path("/third-party")
public class ThirdPartyController {
    private static final ThirdPartyService thirdPartyService = new ThirdPartyService();

    @GET
    @Produces("application/json")
    public LatLng getCurrentCoordinates() throws IOException, InterruptedException, ApiException {
        return thirdPartyService.getCoordinates();
    }

}
