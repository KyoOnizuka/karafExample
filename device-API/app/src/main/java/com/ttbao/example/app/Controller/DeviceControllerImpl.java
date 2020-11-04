package com.ttbao.example.app.Controller;


import com.ttbao.example.app.DTO.DeviceDTO;
import com.ttbao.example.device.ServiceImpl.Interface.DeviceService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DeviceControllerImpl implements DeviceController {
    public static DeviceService m_deviceService;

    public void setM_deviceService(DeviceService m_deviceService) {
        DeviceControllerImpl.m_deviceService = m_deviceService;
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public String getDevice(@PathParam("id") int id) throws Exception {
        return m_deviceService.getDeviceById(id);
    }

    @Override
    @GET
    @Path("/")
    @Produces("application/json")
    public String getAll() {
        return m_deviceService.getAll();
    }

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createDevice(DeviceDTO deviceDTO) throws Exception {
        System.out.println(deviceDTO.getM_description());
        try {
            m_deviceService.addDevice(deviceDTO);
        } catch (Exception e) {
            System.out.println(e);
            return Response.serverError().entity(e).build();
        }
        return Response.status(200).build();
    }

    @Override
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDevice(DeviceDTO deviceDTO, @PathParam("id") int id) {
        try {
            m_deviceService.updateDevice(deviceDTO);
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
        return Response.ok().entity(deviceDTO).build();
    }

    @Override
    @DELETE
    @Path("/{id}")
    public Response delDevice(@PathParam("id") int id) {
        try {
            m_deviceService.delDevice(id);
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
        return Response.ok().build();
    }
}