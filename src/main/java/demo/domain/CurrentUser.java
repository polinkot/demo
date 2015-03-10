package demo.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private Long id;
    private Role role;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.id = user.getId();
        this.role = user.getRole();
    }

    public Long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
