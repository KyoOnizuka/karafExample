package com.ttbao.example.device.Converter;

import com.ttbao.example.app.DTO.DeviceDTO;
import com.ttbao.example.device.Entity.Device;

import java.util.LinkedList;
import java.util.List;

public class DeviceConverterUtil {
    public static DeviceDTO convertToDTO(Device deviceEntity) {
        return new DeviceDTO(deviceEntity.getId(), deviceEntity.getDescription(), deviceEntity.getDeviceName());
    }

    public static Device convertToEntity(DeviceDTO deviceDTO) {
        return new Device( deviceDTO.getM_deviceName(), deviceDTO.getM_description());
    }

    public static List<DeviceDTO> convertToDTOS(List<Device> deviceEntityList) {
        List<DeviceDTO> deviceDTOS = new LinkedList<>();

        deviceEntityList.forEach(deviceEntity -> {
            deviceDTOS.add(convertToDTO(deviceEntity));
        });
        return deviceDTOS;
    }
}
