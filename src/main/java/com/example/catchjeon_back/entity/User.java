package com.example.catchjeon_back.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.*;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "time")
    private Long time;

    @Builder
    public User(String email, String password, String auth, Long time) {
        this.email = email;
        this.password = password;
        this.time = time;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





    public static class Ranking {
        public static void main(String[] args) {
            String jdbcUrl = "jdbc:h2:mem:testdb"; // H2 데이터베이스 URL
            String username = "sa"; // 데이터베이스 사용자명
            String password = ""; // 데이터베이스 비밀번호

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                String sql = "SELECT nickname, email, time FROM users ORDER BY time ASC"; // 랭킹 조회 쿼리
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    int rank = 1;
                    while (resultSet.next()) {
                        String nickname = resultSet.getString("nickname");
                        String email = resultSet.getString("email");
                        String time = resultSet.getTimestamp("time").toString();
                        System.out.println("Rank " + rank + ": " + nickname + " (" + email + ") - " + time);
                        rank++;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
