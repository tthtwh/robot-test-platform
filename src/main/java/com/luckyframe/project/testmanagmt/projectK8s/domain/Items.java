package com.luckyframe.project.testmanagmt.projectK8s.domain;

public class Items {

    private Metadata metadata;
    private String app_id;
    private String name;
    private String package_name;
    private String version_id;


    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getVersion_id() {
        return version_id;
    }

    public void setVersion_id(String version_id) {
        this.version_id = version_id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "metadata=" + metadata +
                ", app_id=" + app_id +
                ", name=" + name +
                ", package_name=" + package_name +
                ", version_id=" + version_id +
                '}';
    }
}
