package lt.techin.zoo.repository;

import lt.techin.zoo.model.Room;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RoomRepository {

    //FIXME temp implementation before going JPA
    private AtomicInteger idGenerator;
    private Map<Long, Room> rooms;

    public RoomRepository() {
        this.rooms = new HashMap<>();
        this.idGenerator = new AtomicInteger();
    }

    public List<Room> findAll() {
        return new ArrayList<>(rooms.values());
    }

    public Room save(Room room) {
        if (room.getId() == null) {
            Long newId = (long) idGenerator.incrementAndGet();
            room.setId(newId);
        }

        rooms.put(room.getId(), room);

        return room;
    }

    public Optional<Room> findById(Long id) {
        return Optional.ofNullable(rooms.get(id));
    }

    public void deleteById(Long id) {
        rooms.remove(id);
    }

}
