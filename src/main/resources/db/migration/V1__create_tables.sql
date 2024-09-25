CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100),
                        email VARCHAR(100),
                        phone VARCHAR(20),
                        address VARCHAR(255)
);

CREATE TABLE pizza (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100),
                       description TEXT,
                       price DECIMAL(10, 2)
);

CREATE TABLE pizza_order (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             client_id BIGINT,
                             date TIMESTAMP,
                             total_price DECIMAL(10, 2),
                             FOREIGN KEY (client_id) REFERENCES client(id)
);

-- Tabela intermediária 'pizza_order_pizza' para o relacionamento Many-to-Many entre 'pizza_order' e 'pizza'
CREATE TABLE pizza_order_items (
                                   pizza_order_id BIGINT NOT NULL,
                                   pizza_id BIGINT NOT NULL,
                                   PRIMARY KEY (pizza_order_id, pizza_id),
                                   FOREIGN KEY (pizza_order_id) REFERENCES pizza_order(id) ON DELETE CASCADE,
                                   FOREIGN KEY (pizza_id) REFERENCES pizza(id) ON DELETE CASCADE
);