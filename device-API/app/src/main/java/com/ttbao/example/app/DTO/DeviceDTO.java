
package com.ttbao.example.app.DTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceDTO {
    private int m_id;
    private String m_deviceName;
    private String m_description;

    public DeviceDTO() {
    }

    public DeviceDTO(int id, String deviceName, String description) {
        this.m_id = id;
        this.m_deviceName = deviceName;
        this.m_description = description;
    }

    public int getM_id() {
        return this.m_id;
    }

    public void setM_id(int id) {
        this.m_id = id;
    }

    public String getM_deviceName() {
        return m_deviceName;
    }

    public void setM_deviceName(String m_deviceName) {
        this.m_deviceName = m_deviceName;
    }

    public String getM_description() {
        return this.m_description;
    }

    public void setM_description(String m_description) {
        this.m_description = m_description;
    }
}
