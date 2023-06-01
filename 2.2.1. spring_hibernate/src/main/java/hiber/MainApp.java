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
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru"));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru"));

      Car car1 = new Car("Ford", 33);
      Car car2 = new Car("Kia", 55);
      Car car3 = new Car("BMW", 777);
      Car car4 = new Car("BMW", 777);
      userService.setCarForUser(1, car1);
      userService.setCarForUser(2, car2);
      userService.setCarForUser(3, car3);
      userService.setCarForUser(5, car4);


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
         List<User> uscars = userService.getUserByCar("BMW", 777);
         for (User us : uscars) {
            System.out.println(us);
         }
      } finally {
         context.close();
      }
   }
}
