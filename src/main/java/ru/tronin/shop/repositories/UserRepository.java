package ru.tronin.shop.repositories;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.tronin.shop.models.User;

import javax.annotation.PostConstruct;
import javax.xml.transform.Result;
import java.sql.*;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserRepository {
    Connection connection;
    final String GET_USER = "select * from users where id = ?";
    final String SAVE_USER = "INSERT INTO users ('email', 'password') VALUES (?,?)";
    @PostConstruct
    public void init(){
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test1");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("CLass was not found", e);
        } catch (SQLException throwables) {
            throw new RuntimeException("Writing to DB was wrong!", throwables);
        }
    }


    public synchronized User getUserById(Long id){
        log.info("Getting user from DB");
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER)){
            String resultNickname = null;
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String resultEmail = resultSet.getString("email");
                String resultPassword = resultSet.getString("password");
                User user = new User();
                user.setId(id);
                user.setEmail(resultEmail);
                user.setPassword(resultPassword);
                return user;
            }
            return null;
        } catch (SQLException throwables) {
            throw new RuntimeException("Something went wrong when we tried to GET user!", throwables);
        }
    }

    public synchronized void saveNewUser(User user){
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)){
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Something went wrong when we tried to SAVE user!", throwables);
        }
    }


}
