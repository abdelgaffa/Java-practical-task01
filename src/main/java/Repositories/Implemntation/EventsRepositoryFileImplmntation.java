package Repositories.Implemntation;
import Repositories.EventsRepository;
import Model.Event;
import Model.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 6/30/2023
 * Repository Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class EventsRepositoryFileImplmntation implements EventsRepository {
    private final String eventFileName;
    private final String eventsAndUsersFileName;

    public EventsRepositoryFileImplmntation(String eventFileName, String eventsAndUsersFileName) {
        this.eventFileName = eventFileName;
        this.eventsAndUsersFileName = eventsAndUsersFileName;
    }

    @Override
    public void save(Event model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventFileName, true))){
            writer.write(model.getId() + "|" + model.getName() + "|" + model.getDate());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Event findByName(String nameEvent) {
        if (nameEvent.equals("Практика по Golang")) {
            return Event.builder()
                    .id("c5bcc553-a8f3-4619-8e34-c19abf75aab5")
                    .name("Практика по Golang")
                    .date(LocalDate.parse("2023-07-01"))
                    .build();
        }
        return null;
    }

    @Override
    public void saveUserToEvent(User user, Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eventsAndUsersFileName, true))){
            writer.write(user.getId() + "|" + event.getId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

 //   @Override
//    public Event findByName1(String nameEvent) {
//        return null;
//    }

    @Override
    public List<Event> findAllByMembersContains(User user) {
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(eventsAndUsersFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String userId = parts[0];
                String eventId = parts[1];
                if (userId.equals(user.getId())) {
                    Event event = findByName(eventId);
                    if (event != null) {
                        events.add(event);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return events;
    }

}

