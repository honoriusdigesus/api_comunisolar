package com.api.comunisolar.presenter.entities;

import java.time.LocalDateTime;

public class UserRequestPresenter {
    private String fullName;
    private String email;
    private String passwordHash;
    private String identityDocument;

    public UserRequestPresenter() {
    }

    public UserRequestPresenter(String fullName, String email, String passwordHash, String identityDocument) {
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.identityDocument = identityDocument;
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

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    @Override
    public String toString() {
        return "UserRequestDomain{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", identityDocument='" + identityDocument + '\'' +
                '}';
    }
}
