package com.emcommerce.service;

import com.emcommerce.dto.request.ReceiverRequest;
import com.emcommerce.entity.Receiver;
import com.emcommerce.mapper.ReceiverMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class ReceiverService {
	private final ReceiverMapper receiverMapper;

	public ReceiverService(ReceiverMapper receiverMapper) {
		this.receiverMapper = receiverMapper;
	}

	List<ReceiverRequest> getReceiver(BigInteger userId){
		List<Receiver> receivers = receiverMapper.getReceiver(userId);

		return receivers.stream().map(receiver -> {
			ReceiverRequest request = new ReceiverRequest();
			request.setName(receiver.getReceiverName());
			request.setPhone(request.getPhone());
			request.setAddress(request.getAddress());
			request.setDefault(receiver.isDefault());
			return request;
		}).toList();
	}

	@Transactional(rollbackFor = Exception.class)
	public void changeDefault(BigInteger userId,BigInteger id){
		receiverMapper.cancelDefault(userId);
		int count = receiverMapper.setDefault(id);
		if (count!=1){
			throw new IllegalArgumentException("修改id无效");
		}
	}

}
