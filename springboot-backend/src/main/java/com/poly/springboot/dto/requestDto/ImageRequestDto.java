package com.poly.springboot.dto.requestDto;

import com.poly.springboot.entity.Product;
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

    private String imageName;

    private String imageLink;

    private String imageDescribe;

}
