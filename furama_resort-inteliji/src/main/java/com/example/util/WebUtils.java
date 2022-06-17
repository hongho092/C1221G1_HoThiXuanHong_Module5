package com.example.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class WebUtils {

    /* file tổng kết cuối cùng, sử dụng để lấy */

    public static String toString(User user) {
        /*
        user sẽ được truyền vào có dạng ->
        org.springframework.security.core.userdetails.User [Username=dbadmin1, Password=[PROTECTED],
        Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true,
        Granted Authorities=[ROLE_ADMIN, ROLE_USER]]
        */

        StringBuilder sb = new StringBuilder();

        sb.append("UserName:").append(user.getUsername());

        Collection<GrantedAuthority> authorities = user.getAuthorities();

        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
        // trả về dạng -- UserName:dbadmin1 (ROLE_ADMIN, ROLE_USER)
    }

}
