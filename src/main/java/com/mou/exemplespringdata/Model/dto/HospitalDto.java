package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalDto {
    private Integer id;
    private String name;

    public static HospitalDto toHospitalDto(Hospital hospital){
        return HospitalDto
                .builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .build();
    }
}
