package Repositories;
import Model.User;


/**
 * 6/30/2023
 * Repository Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByEmail(String emailUser);

  //  User findByEmail1(String emailUser);


}
