package app.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Светлана on 28.07.2018.
 */
public enum Role implements GrantedAuthority {
    ADMIN, USER;

    //возвращает название права пользователя в виде строки
    @Override
    public String getAuthority() {
        return this.toString();
    }
}