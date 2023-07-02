package Repositories;
import Model.Event;
import Model.User;

import java.util.List;

/**
 * 6/30/2023
 * Repository Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface EventsRepository extends CrudRepository<Event, Number> {
    Event findByName(String nameEvent);

    void saveUserToEvent(User user, Event event);

//    Event findByName1(String nameEvent);

    List<Event> findAllByMembersContains(User user);

}

