package com.ttbao.example.device.ServiceImpl.Interface;

import com.ttbao.example.app.DTO.DeviceDTO;
import com.ttbao.example.device.Entity.Device;

public interface DeviceService {


    String getDeviceById(Integer id);

    void addDevice(DeviceDTO deviceDTO);

    void delDevice(Integer id);

    void updateDevice(DeviceDTO deviceDTO);

    String getAll();
}
