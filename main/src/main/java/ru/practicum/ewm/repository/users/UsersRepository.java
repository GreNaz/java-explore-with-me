package ru.practicum.ewm.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.users.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
