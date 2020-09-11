package com.alykhaled.gdgproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SubmitItem implements Serializable {

    @SerializedName("entry.1877115667")
    @Expose
    private String firstMame;

    @SerializedName("entry.1824927963")
    @Expose
    private String emailAddress;

    @SerializedName("entry.2006916086")
    @Expose
    private String lastName;

    @SerializedName("entry.284483984")
    @Expose
    private String projectLink;

    public SubmitItem(String firstMame, String emailAddress, String lastName, String projectLink) {
        this.firstMame = firstMame;
        this.emailAddress = emailAddress;
        this.lastName = lastName;
        this.projectLink = projectLink;
    }

    public String getFirstMame() {
        return firstMame;
    }

    public void setFirstMame(String firstMame) {
        this.firstMame = firstMame;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    @Override
    public String toString() {
        return "SubmitItem{" +
                "firstMame='" + firstMame + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", lastName='" + lastName + '\'' +
                ", projectLink='" + projectLink + '\'' +
                '}';
    }
}
