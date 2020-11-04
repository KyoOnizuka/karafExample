package com.ttbao.example.app;

import com.ttbao.example.app.Controller.DeviceControllerImpl;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.List;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Server Setup");
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        try {
            factoryBean.setResourceClasses(DeviceControllerImpl.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        factoryBean.setBus(BusFactory.getDefaultBus());
        factoryBean.setResourceClasses(DeviceControllerImpl.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new DeviceControllerImpl()));
        factoryBean.setServiceBean(new DeviceControllerImpl());
        factoryBean.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
        List<Object> providers = new ArrayList<Object>();
        factoryBean.setProviders(providers);
        factoryBean.setAddress("http://localhost:8080");
        Server server = factoryBean.create();
        server.start();

    }

    @Override
    public void stop(BundleContext context) throws Exception {

    }
}
