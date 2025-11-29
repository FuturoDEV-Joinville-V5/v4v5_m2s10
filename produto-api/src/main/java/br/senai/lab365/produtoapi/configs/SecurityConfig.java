package br.senai.lab365.produtoapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

  @Bean
  public SecurityFilterChain filterChain(final HttpSecurity http, final JwtFilter jwtFilter)
      throws Exception {
    http.authorizeHttpRequests(
            auth ->
                auth.requestMatchers("/auth", "/usuarios")
                    .permitAll()
                    .requestMatchers("/dashboard")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated())
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(
            s ->
                s.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS)) // Gerenciamento de sessão STATELESS
        .httpBasic(Customizer.withDefaults())
        .formLogin(AbstractHttpConfigurer::disable);
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(
      final AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  /*@Bean
  public UserDetailsService inMemoryUserDetailsService(final PasswordEncoder passwordEncoder) {
    final UserDetails user =
        User.builder()
            .username("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();
    final UserDetails admin =
        User.builder()
            .username("admin")
            .password(passwordEncoder.encode("superstrongpassword"))
            .roles("ADMIN")
            .build();
    return new InMemoryUserDetailsManager(user, admin);
  }*/
}
