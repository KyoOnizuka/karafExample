package com.ttbao.example.device.DAO;

import com.ttbao.example.device.Entity.Device;

import java.util.List;

public interface IDeviceDAO {

    public List<Device> findAll();

    public Device findById(Integer id);

    public void save(Device deviceEntity);

    public void update(Device deviceEntity);

    public void delete(Integer id);
}
