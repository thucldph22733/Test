package com.poly.springboot.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    @NotBlank(message = "Tên khách hàng không được để trống!")
    private String customerName;

    private String avatar;

    @NotBlank(message = "Số điện thoại không được để trống!")
    private String phoneNumber;

    @NotBlank(message = "Email không được để trống!")
    @Email(message = "Địa chỉ email không đúng định dạng!")
    private String email;

    private Boolean gender;

    private Date birthOfDay;

    @NotBlank(message = "Mật khẩu không được để trống!")
    private String password;

    private Integer status;

}
