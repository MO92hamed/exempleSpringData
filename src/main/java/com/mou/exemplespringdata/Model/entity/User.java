package com.mou.exemplespringdata.Model.entity;

import com.mou.exemplespringdata.Model.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_password")
    private String password;

    public static User toUserEntity(UserDto userDto){
        return User
                .builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .build();
    }
}
