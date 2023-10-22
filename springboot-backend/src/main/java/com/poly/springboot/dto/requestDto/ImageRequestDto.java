package com.poly.springboot.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageRequestDto {

    private Long productId;

    @NotBlank(message = "Vui lòng nhập tên Mau!")
    private String imageName;

    @NotBlank(message = "Vui lòng nhập tên Mau!")
    private String imageDescribe;
}
