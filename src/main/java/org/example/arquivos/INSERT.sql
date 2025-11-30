-- Inserção de Planos (baseado no arquivo planos.txt)
INSERT INTO Plano (nome, descricao, velocidade, preco)
VALUES 
    ('Básico', 'Plano básico de internet para uso residencial', 50.00, 79.90),
    ('Intermediário', 'Plano intermediário ideal para famílias', 100.00, 129.90),
    ('Avançado', 'Plano avançado para usuários que precisam de alta velocidade', 200.00, 199.90),
    ('Premium', 'Plano premium com máxima velocidade e estabilidade', 500.00, 349.90),
    ('Ultra', 'Plano ultra para empresas e gamers', 1000.00, 599.90);

-- Inserção de Clientes
INSERT INTO Cliente (nome, endereco, contato, plano_id)
VALUES 
    ('João Silva', 'Rua José Eraldo, 123 - Centro', '(81) 9999-8888', 1),
    ('Maria Santos', 'Av. B, 456 - Jardim', '(81) 9777-6666', 2),
    ('Pedro Costa', 'Rua Matriz, 789 - Vila', '(81) 9555-4444', 3),
    ('Ana Oliveira', 'Rua das Oliveiras, 321 - Bairro', '(81) 9333-2222', 4),
    ('Carlos Lima', 'Rua da Velhas, 654 - Centro', '(81) 9111-0000', 5),
    ('Alberto Morais', 'Rua Da Esperança 80', '(81) 9028-4422', 2),
    ('Fernanda Rocha', 'Rua José de Creuza, 987 - Parque', '(81) 9444-3333', 1),
    ('Ricardo Alves', 'Av. G, 654 - Jardim', '(81) 9222-1111', 1),
    ('Juliana Martins', 'Rua Joca Geraldo, 321 - Centro', '(81) 9888-7777', 3),
    ('Bruno Ferreira', 'Av. I, 159 - Vila', '(81) 9666-5555', 3),
    ('Patrícia Souza', 'Rua Iolanda Pereira, 753 - Bairro', '(81) 9333-2222', 2);

-- Inserção de Estoque
INSERT INTO Estoque (nome, descricao, quantidade)
VALUES 
    ('Estoque Principal', 'Estoque principal de equipamentos de rede', 10);

-- Inserção de Equipamentos (relacionados ao Estoque)
INSERT INTO Equipamento (tipo, entregue, estoque_id)
VALUES 
    ('Modem WiFi', FALSE, 1),
    ('Roteador', FALSE, 1),
    ('Cabo Ethernet', FALSE, 1),
    ('Antena Externa', FALSE, 1),
    ('Conversor Óptico', FALSE, 1),
    ('Modem WiFi', FALSE, 1),
    ('Roteador', FALSE, 1),
    ('Cabo Ethernet', TRUE, 1),
    ('Antena Externa', TRUE, 1),
    ('Conversor Óptico', FALSE, 1);
