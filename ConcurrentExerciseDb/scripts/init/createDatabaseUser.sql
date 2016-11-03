CREATE USER 'steven'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'steven'@'localhost';

FLUSH PRIVILEGES;