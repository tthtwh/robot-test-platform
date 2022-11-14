package com.luckyframe.project.testmanagmt.projectK8s.domain;

import java.util.Date;

public class Metadata {

    private String name;
    private String generateName;
    private String namespace;
    private String uid;
    private String resourceVersion;
    private Date creationTimestamp;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenerateName() {
        return generateName;
    }

    public void setGenerateName(String generateName) {
        this.generateName = generateName;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public String toString() {
        return "MetadataK8s{" +
                "name='" + name + '\'' +
                ", generateName='" + generateName + '\'' +
                ", namespace='" + namespace + '\'' +
                ", uid='" + uid + '\'' +
                ", resourceVersion='" + resourceVersion + '\'' +
                ", creationTimestamp=" + creationTimestamp +
                '}';
    }
}
