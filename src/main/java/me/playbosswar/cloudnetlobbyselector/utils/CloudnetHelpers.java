package me.playbosswar.cloudnetlobbyselector.utils;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;

import java.util.Collection;

public class CloudnetHelpers {
    public static Collection<ServiceInfoSnapshot> getServers(String taskName) {
        Collection<ServiceInfoSnapshot> servers = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServicesByGroup(taskName);
        return servers;
    }
}
