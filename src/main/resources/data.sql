INSERT INTO client(name)
VALUES('Hélder');

INSERT INTO client(name)
VALUES('Robson');

INSERT INTO client(name)
VALUES('Rodolfo');

INSERT INTO account(account, agency, account_balance, client_id)
VALUES('713830-03', '7714', 25, (SELECT id FROM client WHERE name = 'Hélder'));

INSERT INTO account(account, agency, account_balance, client_id)
VALUES('195758-89', '6294', 35.22, (SELECT id FROM client WHERE name = 'Robson'));

INSERT INTO account(account, agency, account_balance, client_id)
VALUES('136936-49', '7714', 50, (SELECT id FROM client WHERE name = 'Rodolfo'));