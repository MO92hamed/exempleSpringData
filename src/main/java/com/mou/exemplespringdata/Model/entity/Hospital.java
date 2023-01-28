package com.mou.exemplespringdata.Model.entity;

import com.mou.exemplespringdata.Model.dto.HospitalDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="_hospital")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Integer id;
    @Column(name = "hospital_name")
    private String name;

    public static Hospital toHospitalEntity(HospitalDto hospitalDto){
        return Hospital
                .builder()
                .id(hospitalDto.getId())
                .name(hospitalDto.getName())
                .build();
    }
}
