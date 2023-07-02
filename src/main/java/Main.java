import Model.Event;
import Repositories.EventsRepository;
import Repositories.UsersRepository;
import Repositories.Implemntation.EventsRepositoryFileImplmntation;
import Repositories.Implemntation.UsersRepositoryFileImplmntation;
import services.AppService;

import java.time.LocalDate;
import java.util.List;

public class Main {
public static void main(String[] args) {
    UsersRepository usersRepository = new Repositories.Implemntation.UsersRepositoryFileImplmntation("users.txt");
    EventsRepository eventsRepository = new Repositories.Implemntation.EventsRepositoryFileImplmntation("events.txt", "events_users.txt");
    AppService appService = new AppService(usersRepository, eventsRepository);

    appService.signUp("admin@gmail.com", "qwerty007");
    appService.signUp("marsel@gmail.com", "qwerty008");

    appService.addEvent("Практика по Java", LocalDate.now());
    appService.addEvent("Практика по Golang", LocalDate.now().plusDays(1));

    appService.addUserToEvent("marsel@gmail.com", "Практика по Golang");

    List<Event> events = appService.getAllEventsByUser("marsel@gmail.com");
    System.out.println(events);
}

}
