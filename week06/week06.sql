CREATE TABLE `z_test_category` (
                                   `category_id` int(11) NOT NULL,
                                   `name` varchar(255) NOT NULL,
                                   `url` varchar(255) NOT NULL,
                                   `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
                                   PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4



CREATE TABLE `z_test_order` (
                                `id` varchar(45) NOT NULL,
                                `category_id` int(11) NOT NULL,
                                `address` varchar(255) NOT NULL,
                                `user_id` int(11) NOT NULL DEFAULT '0',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4



CREATE TABLE `z_test_user` (
                               `id` varchar(45) NOT NULL,
                               `username` varchar(16) NOT NULL,
                               `email` varchar(255) NOT NULL,
                               `password` varchar(32) NOT NULL,
                               `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4