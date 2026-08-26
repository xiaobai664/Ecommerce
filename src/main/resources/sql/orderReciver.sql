CREATE TABLE order_receiver (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '收货信息ID',

    user_id BIGINT NOT NULL COMMENT '用户ID',

    receiver_name VARCHAR(50) NOT NULL COMMENT '收货人姓名',
    receiver_phone VARCHAR(20) NOT NULL COMMENT '收货人电话',
    receiver_address VARCHAR(255) NOT NULL COMMENT '收货地址',

    is_default TINYINT NOT NULL DEFAULT 0 COMMENT '是否默认地址',

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    PRIMARY KEY (id),

    INDEX idx_order_receiver_user_id (user_id),

    CONSTRAINT fk_order_receiver_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)

) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COMMENT='用户收货地址';