package ru.practicum.ewm.service.events.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.model.categories.Category;
import ru.practicum.ewm.model.errors.ConflictException;
import ru.practicum.ewm.model.errors.NotFoundException;
import ru.practicum.ewm.model.events.Event;
import ru.practicum.ewm.model.events.EventMapper;
import ru.practicum.ewm.model.events.dto.EventFullDto;
import ru.practicum.ewm.model.events.dto.UpdateEventAdminRequest;
import ru.practicum.ewm.repository.categories.CategoriesRepository;
import ru.practicum.ewm.repository.events.EventsRepository;
import ru.practicum.ewm.repository.location.LocationRepository;
import ru.practicum.ewm.service.events.EventsAdminService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static ru.practicum.ewm.model.events.AdminStateAction.PUBLISH_EVENT;
import static ru.practicum.ewm.model.events.AdminStateAction.REJECT_EVENT;
import static ru.practicum.ewm.model.events.State.CANCELED;
import static ru.practicum.ewm.model.events.State.PUBLISHED;

@Service
@RequiredArgsConstructor
public class EventsAdminServiceImpl implements EventsAdminService {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final EventsRepository eventsRepository;
    private final CategoriesRepository categoriesRepository;
    private final LocationRepository locationRepository;

    @Override
    public List<EventFullDto> getEvents(List<Integer> users,
                                        List<Integer> categories,
                                        List<String> states,
                                        String rangeStart,
                                        String rangeEnd,
                                        Pageable pageable) {
        return null;
    }

    @Override
    public EventFullDto updateEvent(UpdateEventAdminRequest updateEventAdminRequest,
                                    Integer eventId) {

        Event event = eventsRepository.findById(eventId).orElseThrow(() -> new NotFoundException("Event not found"));

        if (updateEventAdminRequest.getEventDate() != null
                && (LocalDateTime.parse(updateEventAdminRequest.getEventDate().format(FORMATTER))
                .isBefore(LocalDateTime.now()))) {
            throw new ConflictException("Date in the past");

        }

        switch (event.getState()) {
            case PUBLISHED:
                if (updateEventAdminRequest.getStateAction().equals(PUBLISH_EVENT)) {
                    throw new ConflictException("Event is already published");
                }
                if (updateEventAdminRequest.getStateAction().equals(REJECT_EVENT)) {
                    throw new ConflictException("Event is published. You can't reject it");
                }
                break;
            case CANCELED:
                if (updateEventAdminRequest.getStateAction().equals(PUBLISH_EVENT)) {
                    throw new ConflictException("Event is canceled");
                }
                break;
            case PENDING:
                if (updateEventAdminRequest.getStateAction().equals(PUBLISH_EVENT)) {
                    event.setState(PUBLISHED);
                }
                if (updateEventAdminRequest.getStateAction().equals(REJECT_EVENT)) {
                    event.setState(CANCELED);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + updateEventAdminRequest.getStateAction());
        }

        if (updateEventAdminRequest.getCategory() != null) {
            Category category = categoriesRepository.findById(updateEventAdminRequest.getCategory().getId()).orElseThrow(()
                    -> new NotFoundException("Category not found for update"));
            event.setCategory(category);
        }

        if (updateEventAdminRequest.getLocation() != null) {
            event.setLocation(locationRepository.save(updateEventAdminRequest.getLocation()));
        }

        eventsRepository.save(event);

        return EventMapper.EVENT_MAPPER.toEventFullDto(event);
    }
}
