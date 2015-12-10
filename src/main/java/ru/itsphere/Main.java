package ru.itsphere;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itsphere.service.PurseService;
import ru.itsphere.service.UserService;

/**
 * http://it-channel.ru/
 * <p>
 * @author Budnikov Aleksandr
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        PurseService purseService = (PurseService) applicationContext.getBean("purseService");

        System.out.println("All purses:");
        purseService.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println("All purses of user with id 1:");
        purseService.getAllByOwnerId(1).forEach(System.out::println);
        System.out.println();

        System.out.println("All users:");
        userService.getAll().forEach(System.out::println);
        System.out.println();

        userService.deleteById(1);

        System.out.println("All purses:");
        purseService.getAll().forEach(System.out::println);
        System.out.println();
    }
}
