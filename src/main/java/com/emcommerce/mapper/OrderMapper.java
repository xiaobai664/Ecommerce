package com.emcommerce.mapper;

import com.emcommerce.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface OrderMapper {
	@Select("""
		SELECT
			id,
			order_no,
			user_id,
			total_amount,
			status,
			payment_method,
			pay_at,
			receiver_id,
			remark,
			created_at,
			updated_at
		FROM orders
		WHERE id=#{id}
		""")
	Order getOrder(BigInteger id);
	@Insert("""
			INSERT INTO orders(
				order_no,
				user_id,
				total_amount,
				status,
				payment_method,
				receiver_id,
				remark
			)
			VALUES(
				#{orderNo},
				#{userId},
				#{totalAmount},
				#{status},
				#{paymentMethod},
				#{receiverId},
				#{remark}
			)
			""")
	@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
	int createOrder(Order order);

	@Select("""
			SELECT
				id,
				order_no,
				total_amount,
				status,
				create_at,
			FROM orders
			WHERE user_id = #{uerId}
			ORDER BY create_at DESC
			LIMIT #{size} OFFSET #{offset}
			""")
	List<Order> getOrdersByUserId(BigInteger userId, int size,int offset);

	@Select("""
    SELECT COUNT(*)
    FROM orders
    WHERE user_id = #{userId}
    """)
	long countOrdersByUserId(BigInteger userId);

	@Update("""
			UPDATE orders
			SET status=#{status}
			WHERE id=#{id}
			""")
	int updateStatus(BigInteger id,String status);

	@Update("""
			UPDATE orders
			SET status = 'CANCELLED'
			WHERE id=#{id}
				ADN status = 'PENDING'
			""")
	int cancelOrder(BigInteger id);
}
