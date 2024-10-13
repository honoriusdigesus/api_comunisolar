package com.api.comunisolar.presenter.entities;

import com.api.comunisolar.domain.entities.RoleDomain;

import java.time.LocalDateTime;

public class UserPresenter {

    private String fullName;
    private String email;
    private String passwordHash;
    private Boolean enabled;
    private String identityDocument;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime activatedAt;
    private RolePresenter role;

    public UserPresenter() {
    }

    public UserPresenter(String fullName, String email, String passwordHash, Boolean enabled, String identityDocument, LocalDateTime createdAt, LocalDateTime activatedAt, RolePresenter role) {
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.enabled = enabled;
        this.identityDocument = identityDocument;
        this.createdAt = createdAt;
        this.activatedAt = activatedAt;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(LocalDateTime activatedAt) {
        this.activatedAt = activatedAt;
    }

    public RolePresenter getRole() {
        return role;
    }

    public void setRole(RolePresenter role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", enabled=" + enabled +
                ", identityDocument='" + identityDocument + '\'' +
                ", createdAt=" + createdAt +
                ", activatedAt=" + activatedAt +
                ", role=" + role +
                '}';
    }
}



