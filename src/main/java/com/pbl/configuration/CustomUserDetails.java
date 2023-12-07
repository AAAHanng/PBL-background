package com.pbl.configuration;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private String customField;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String customField) {
        super(username, password, authorities);
        this.customField = customField;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String CustomField) {
        this.customField = CustomField;
    }

}
