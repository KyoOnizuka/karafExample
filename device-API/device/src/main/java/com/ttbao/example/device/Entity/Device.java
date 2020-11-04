package com.ttbao.example.device.Entity;

import javax.persistence.*;

@Entity
@Table(name = "DEVICE")
public class Device {

    private int id;
    private String deviceName;
    private String description;

    public Device() {
    }

    public Device(String deviceName, String description) {
        this.deviceName = deviceName;
        this.description = description;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    @Column(name = "deviceName")
    public String getDeviceName() {
        return this.deviceName;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
