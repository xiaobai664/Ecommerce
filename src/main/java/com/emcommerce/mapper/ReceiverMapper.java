package com.emcommerce.mapper;

import com.emcommerce.entity.Receiver;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ReceiverMapper {
	@Select("""
			SELECT
				id,
				user_id,
				receiver_name,
				receiver_phone,
				receiver_address,
				is_default,
				created_at
			WHERE
				user_id = #{userId}
			""")
	List<Receiver> getReceiver(BigInteger userId);

	@Insert("""
			INSERT INTO order_receiver(
				user_id,
				receiver_name,
				receiver_phone,
				receiver_address,
				is_default
			)
			VALUES(
				#{userId},
				#{receiverName},
				#{receiverPhone},
				#{receiverAddress},
				#{isDefault}
			)
			""")
	int createReceiver(Receiver receiver);

	@Delete("""
			DELETE FROM order_receiver
			WHERE id = #{id}
			""")
	int removeReceiver(BigInteger id);

	@Update("""
			UPDATE order_receiver
				set is_default = false
			WHERE
				user_id = #{userId} AND is_default = true;
			""")
	int cancelDefault(BigInteger userId);

	@Update("""
			UPDATE order_receiver
				set is_default = true
			WHERE
				id = #{id}
			""")
	int setDefault(BigInteger id);

}
