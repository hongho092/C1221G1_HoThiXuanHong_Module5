package com.example.config;

import com.example.service.login.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    userDetails (lấy tên người dùng, lấy password của người dùng, lấy tất cả các role của người dùng)

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests().antMatchers("/", "/login", "/logout",
                "/customer/list_customer_service_now").permitAll();
//        http.authorizeRequests().antMatchers("/*").permitAll();

        http.authorizeRequests().antMatchers("/employee/*",
                                                        "/service/*",
                                                        "/customer/save_customer_type",
                                                        "/contract/*",
                                                        "/contract_detail/*",
                                                        "/attach_service/*"
                                                        ).access("hasRole('ROLE_BOSS')");

        http.authorizeRequests().antMatchers("/customer/list",
                                                        "/customer/create",
                                                        "/customer/save",
                                                        "/customer/delete",
                                                        "/customer/edit",
                                                        "/customer/save_edit",
                                                        "/customer/detail",
                                                        "/customer/list_customer_type"
                                                        ).access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_BOSS')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/login/403");

        http.authorizeRequests().and().formLogin()//
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login/logoutSuccessful");

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(60 * 60); // 1h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}
