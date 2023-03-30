package ru.practicum.ewm.repository.users;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.users.User;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findAllByIdIn(List<Integer> ids, Pageable pageable);

}
