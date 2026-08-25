CREATE TABLE `users` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,

    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(255) NOT NULL,

    `email` VARCHAR(100) DEFAULT NULL,
    `phone` VARCHAR(20) DEFAULT NULL,

    `role` VARCHAR(20) NOT NULL DEFAULT 'USER',

    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (`id`),

    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_email` (`email`),
    UNIQUE KEY `uk_phone` (`phone`),

    CONSTRAINT `chk_username_length`
        CHECK (CHAR_LENGTH(`username`) >= 3),

    CONSTRAINT `chk_role`
        CHECK (`role` IN ('USER', 'ADMIN'))
)
ENGINE=InnoDB
AUTO_INCREMENT=5
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;