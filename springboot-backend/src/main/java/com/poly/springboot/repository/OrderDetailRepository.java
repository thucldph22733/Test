package com.poly.springboot.repository;

import com.poly.springboot.dto.responseDto.OrderDetailResponseDto;
import com.poly.springboot.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    @Query(value = "select od.id,p.product_avatar,colors.color_name,sizes.size_name,p.product_name,od.quantity,od.price\n" +
//            "from product_details as pd join products as p on pd.product_id = p.id \n" +
//            " join order_details as od on pd.id = od.product_detail_id\n" +
//            " join colors on pd.color_id = colors.id \n" +
//            " join sizes on pd.size_id = sizes.id;",nativeQuery = true)
//    List<OrderDetail> getOrderDetails();
}
