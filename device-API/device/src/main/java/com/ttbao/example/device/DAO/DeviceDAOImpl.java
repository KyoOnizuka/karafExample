package com.ttbao.example.device.DAO;

import com.ttbao.example.device.Entity.Device;

import java.util.*;

import javax.naming.NamingException;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


public class DeviceDAOImpl implements IDeviceDAO {

    @PersistenceContext(unitName = "device")
    private EntityManager m_storeEntityManager;

    public DeviceDAOImpl() {
    }

    @Override
    @Transactional
    public List<Device> findAll() {
        try {
            return m_storeEntityManager.createQuery("SELECT c FROM Device c", Device.class).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    @Transactional
    public Device findById(Integer id) {
        return m_storeEntityManager.find(Device.class, id);
    }

    @Override
    @Transactional
    public void save(Device deviceEntity) { m_storeEntityManager.persist(deviceEntity); }

    @Override
    @Transactional
    public void update(Device deviceEntity) {
        m_storeEntityManager.merge(deviceEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Device deviceEntity = m_storeEntityManager.find(Device.class, id);
        m_storeEntityManager.remove(deviceEntity);
    }
}
