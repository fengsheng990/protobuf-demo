package com.pinkpig.protobuf;

import java.util.UUID;

import org.junit.Test;

import com.google.protobuf.ByteString;
import com.pinkpig.entity.protobuf.MessageProto.MessageData;
import com.pinkpig.entity.protobuf.MessageProto.SysHeader;
import com.pinkpig.entity.protobuf.OrderInfoProto.OrderInfo;


public class ProtoTest {

	@Test
	public void serilize() {
		SysHeader.Builder headerBuilder = SysHeader.newBuilder();
		SysHeader header = headerBuilder.setBizSeqNo(UUID.randomUUID().toString())
			.setSysSeqNo(UUID.randomUUID().toString())
			.setUserId("pinkpig")
			.setChannelId("WEB")
			.build();
		OrderInfo.Builder builder = OrderInfo.newBuilder();
		OrderInfo orderIndo = builder.setOrderId(UUID.randomUUID().toString())
			.setUserId("pinkpig")
			.setOrderPrice(100.00)
			.setDeliveryPrice(20.00)
			.setDeliveryMethod("京东物流")
			.setReceiverName("pinkpig")
			.setReceiverAddress("广东省深圳市宝安区西乡街道")
			.setOrderDatetime("20190728231800")
			.setPayMethod("微信支付")
			.setPayDatetime("20190728232000")
			.build();
		MessageData.Builder messageBuilder = MessageData.newBuilder();
		MessageData messageData = messageBuilder.setSysHeader(header)
				.setContent(ByteString.copyFrom(orderIndo.toByteArray())).build();
		System.out.println(messageData.toByteArray().length);
	}
}
