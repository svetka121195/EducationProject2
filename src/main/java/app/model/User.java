package app.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users2")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", length = 256)
    private String name;

    @Column(name = "user_login", length = 256, unique = true)
    private String login;

    @Column(name = "user_password", length = 256)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", length = 256, columnDefinition="enum('ADMIN','USER')")
    private Role role = Role.USER;

    public User() {
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password, Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }





    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    // возвращает коллекцию прав пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set <Role> set = new HashSet<>();
        set.add(role);
        return set;
    }

    @Override
    public String getUsername() {
        return login;
    }


    //говорит что аккаунт актуален
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //говорит что аккаунт не заблокирован
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //говорит что учетные данные актуальны
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //говорит что аккаунт включен
    @Override
    public boolean isEnabled() {
        return true;
    }
}

