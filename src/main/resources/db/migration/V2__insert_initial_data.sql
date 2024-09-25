INSERT INTO client (name, email, phone, address) VALUES
                                                     ('João Silva', 'joao.silva@email.com', '(11) 98765-4321', 'Rua A, 123, São Paulo, SP'),
                                                     ('Maria Oliveira', 'maria.oliveira@email.com', '(11) 91234-5678', 'Rua B, 456, São Paulo, SP'),
                                                     ('Carlos Souza', 'carlos.souza@email.com', '(11) 99876-5432', 'Rua C, 789, São Paulo, SP');


INSERT INTO pizza (name, description, price) VALUES
                                                 ('Margherita', 'Molho de tomate, mussarela e manjericão', 25.50),
                                                 ('Pepperoni', 'Molho de tomate, mussarela e pepperoni', 30.00),
                                                 ('Frango com Catupiry', 'Molho de tomate, frango desfiado, catupiry', 35.00),
                                                 ('Quatro Queijos', 'Molho de tomate, mussarela, provolone, parmesão, gorgonzola', 40.00);


INSERT INTO pizza_order (client_id, date, total_price) VALUES
                                                           (1, NOW(), 55.50),
                                                           (2, NOW(), 30.00),
                                                           (3, NOW(), 75.00);


INSERT INTO pizza_order_items(pizza_order_id, pizza_id) VALUES
                                                             (1, 1), -- Pedido 1, Pizza Margherita
                                                             (1, 2), -- Pedido 1, Pizza Pepperoni
                                                             (2, 3), -- Pedido 2, Pizza Frango com Catupiry
                                                             (3, 2), -- Pedido 3, Pizza Pepperoni
                                                             (3, 4); -- Pedido 3, Pizza Quatro Queijos
