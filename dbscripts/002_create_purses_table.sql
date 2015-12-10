/**
 * http://it-channel.ru/
 * <p>
 * @author Budnikov Aleksandr
 */
CREATE TABLE purses
(
  id BIGINT AUTO_INCREMENT,
  ownerId BIGINT,
  name VARCHAR(255),
  currency VARCHAR(255),
  amount DECIMAL,
  PRIMARY KEY (id),
  FOREIGN KEY (ownerId) REFERENCES users(id)
);
