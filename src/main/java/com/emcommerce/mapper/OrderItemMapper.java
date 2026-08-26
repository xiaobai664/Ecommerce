package com.emcommerce.mapper;

import com.emcommerce.entity.Order;
import com.emcommerce.entity.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface OrderItemMapper {
	@Insert("""
			INSERT INTO order_item(
				order_id,
				product_id,
				product_name,
				price,
				quantity
			)
			VALUES(
				#{orderId},
				#{productId},
				#{productName},
				#{price},
				#{quantity}
			)
			""")
	int createOrderItem(OrderItem orderItem);
	@Select("""
			SELECT(
				id,
				order_id,
				product_name,
				price,
				quantity,
				create_at
			)
			FROM order_item
			WHERE order_id=#{orderId}
			""")
	List<OrderItem> getItemByOrderId(BigInteger orderId);
}
