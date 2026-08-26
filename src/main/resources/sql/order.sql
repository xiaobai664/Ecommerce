CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,

    -- 订单编号
    order_no VARCHAR(64) NOT NULL,

    -- 下单用户
    user_id BIGINT NOT NULL,

    -- 订单金额
    total_amount DECIMAL(10,2) NOT NULL DEFAULT 0.00,

    -- 订单状态
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',

    -- 支付信息
    payment_method VARCHAR(20) DEFAULT NULL,
    paid_at DATETIME DEFAULT NULL,

    -- 收货信息
    receiver_name VARCHAR(50) NOT NULL,
    receiver_phone VARCHAR(20) NOT NULL,
    receiver_address VARCHAR(255) NOT NULL,

    -- 订单备注
    remark VARCHAR(500) DEFAULT NULL,

    -- 时间
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    -- 订单号不能重复
    UNIQUE KEY uk_order_no (order_no),

    -- 用户查询自己的订单
    INDEX idx_order_user_id (user_id),

    -- 后台按照状态查询订单
    INDEX idx_order_status (status),

    -- 用户 + 时间查询订单
    INDEX idx_order_user_created (user_id, created_at),

    -- 数据完整性
    CONSTRAINT fk_order_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT chk_order_amount
        CHECK (total_amount >= 0),

    CONSTRAINT chk_order_status
        CHECK (
            status IN (
                'PENDING',
                'PAID',
                'SHIPPED',
                'COMPLETED',
                'CANCELLED',
                'REFUNDING',
                'REFUNDED'
            )
        )
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;






CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) NOT NULL,
  `user_id` bigint NOT NULL,
  `total_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `status` varchar(20) NOT NULL DEFAULT 'PENDING',
  `payment_method` varchar(20) DEFAULT NULL,
  `paid_at` datetime DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `receiver_id` bigint NOT NULL COMMENT '订单收货信息ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`),
  KEY `idx_order_user_id` (`user_id`),
  KEY `idx_order_status` (`status`),
  KEY `idx_order_user_created` (`user_id`,`created_at`),
  KEY `fk_orders_receiver` (`receiver_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_orders_receiver` FOREIGN KEY (`receiver_id`) REFERENCES `order_receiver` (`id`),
  CONSTRAINT `chk_order_amount` CHECK ((`total_amount` >= 0)),
  CONSTRAINT `chk_order_status` CHECK ((`status` in (_utf8mb4'PENDING',_utf8mb4'PAID',_utf8mb4'SHIPPED',_utf8mb4'COMPLETED',_utf8mb4'CANCELLED',_utf8mb4'REFUNDING',_utf8mb4'REFUNDED')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci