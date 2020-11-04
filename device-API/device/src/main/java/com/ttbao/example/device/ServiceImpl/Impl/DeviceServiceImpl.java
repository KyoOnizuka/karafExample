package com.ttbao.example.device.ServiceImpl.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ttbao.example.app.DTO.DeviceDTO;
import com.ttbao.example.device.Converter.DeviceConverterUtil;
import com.ttbao.example.device.DAO.DeviceDAOImpl;
import com.ttbao.example.device.Entity.Device;
import com.ttbao.example.device.ServiceImpl.Interface.DeviceService;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DeviceServiceImpl implements DeviceService {
    public static DeviceDAOImpl m_deviceDAO;

    public void setM_deviceDAO(DeviceDAOImpl m_deviceDAO) {
        DeviceServiceImpl.m_deviceDAO = m_deviceDAO;
    }

    @Override
    public String getDeviceById(Integer id) {

        Map<Object, Object> map = new HashMap<>();
        Gson gson = new Gson();

        Device deviceEntity = m_deviceDAO.findById(id);

        DeviceDTO deviceDTO = DeviceConverterUtil.convertToDTO(deviceEntity);
        map.put(ResponseEnum.code, HttpStatus.SC_OK);
        map.put(ResponseEnum.status, StatusEnum.SUCCESS);
        map.put(DeviceDTO.class.getSimpleName(), deviceDTO);
        Type gsonType = new TypeToken<HashMap>() {
        }.getType();
        String gsonString = gson.toJson(map, gsonType);
        return gsonString;
    }

    @Override
    public void addDevice(DeviceDTO deviceDTO) {
        Device deviceEntity = DeviceConverterUtil.convertToEntity(deviceDTO);
        System.out.println(deviceDTO.getM_description()+deviceDTO.getM_deviceName()+deviceEntity.getDescription());
        m_deviceDAO.save(deviceEntity);
    }

    @Override
    public void delDevice(Integer id) {
        m_deviceDAO.delete(id);
    }

    @Override
    public void updateDevice(DeviceDTO deviceDTO) {
        Device device = DeviceConverterUtil.convertToEntity(deviceDTO);
        device.setId(deviceDTO.getM_id());
        m_deviceDAO.update(device);
    }

    @Override
    public String getAll() {
        Map<Object, Object> map = new HashMap<>();
        Gson gson = new Gson();
        List<DeviceDTO> deviceDTOS = DeviceConverterUtil.convertToDTOS(m_deviceDAO.findAll());

        //extract constant
        map.put(ResponseEnum.code, HttpStatus.SC_OK);
        map.put(ResponseEnum.status, StatusEnum.SUCCESS);
        map.put(DeviceDTO.class.getSimpleName(), deviceDTOS);

        Type gsonType = new TypeToken<HashMap>() {}.getType();
        String gsonString = gson.toJson(map, gsonType);
        System.out.println(gsonString);
        return gsonString;
    }
}
