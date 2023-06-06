package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Ford", 33);
      Car car2 = new Car("Kia", 55);
      Car car3 = new Car("BMW", 777);
      Car car4 = new Car("BMW", 6);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(car1);
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(car2);
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(car3);
      userService.add(user3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(car4);
      userService.add(user4);
      User user5 = new User("User5", "Lastname5", "user5@mail.ru");
      userService.add(user5);
      User user6 = new User("User6", "Lastname6", "user6@mail.ru");
      userService.add(user6);

      try {
         List<User> users = userService.listUsers();
         for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("car = "+user.getCar());
            System.out.println(user);
         }
         System.out.println("-----------------------------------------------------------------------------------");
         User uscars = userService.getUserByCar("BMW", 777);
         System.out.println(uscars);

      } finally {
         context.close();
      }
   }
}
