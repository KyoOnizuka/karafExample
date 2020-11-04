package com.ttbao.example.app.Controller;

import com.ttbao.example.app.DTO.DeviceDTO;

import javax.ws.rs.core.Response;

public interface DeviceController {

    String getDevice(int id) throws Exception;

    String getAll();

    Response createDevice(DeviceDTO deviceDTO) throws Exception;

    Response updateDevice(DeviceDTO deviceDTO, int id);

    Response delDevice(int id);

}
