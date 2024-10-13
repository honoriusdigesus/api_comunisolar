package com.api.comunisolar.presenter.entities;

import com.api.comunisolar.domain.entities.RoleDomain;

public class UserResponsePresenter {
    private String fullName;
    private String email;
    private Boolean enabled;
    private String identityDocument;
    private RolePresenter role;

    public UserResponsePresenter() {
    }

    public UserResponsePresenter(String fullName, String email, Boolean enabled, String identityDocument, RolePresenter role) {
        this.fullName = fullName;
        this.email = email;
        this.enabled = enabled;
        this.identityDocument = identityDocument;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public RolePresenter getRole() {
        return role;
    }

    public void setRole(RolePresenter role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RequestResponseDomain{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", identityDocument='" + identityDocument + '\'' +
                ", role=" + role +
                '}';
    }
}
