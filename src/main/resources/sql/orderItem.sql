CREATE TABLE order_item (
    id BIGINT NOT NULL AUTO_INCREMENT,

    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,

    -- 下单时的商品快照
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (id),

    INDEX idx_order_item_order_id (order_id),
    INDEX idx_order_item_product_id (product_id),

    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id),

    CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id)
        REFERENCES product(id),

    CONSTRAINT chk_order_item_price
        CHECK (price >= 0),

    CONSTRAINT chk_order_item_quantity
        CHECK (quantity > 0)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;