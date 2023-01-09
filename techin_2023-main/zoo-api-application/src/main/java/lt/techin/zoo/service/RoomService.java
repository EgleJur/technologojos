package lt.techin.zoo.service;

import lt.techin.zoo.api.dto.RoomDto;
import lt.techin.zoo.api.dto.mapper.RoomMapper;
import lt.techin.zoo.model.Room;
import lt.techin.zoo.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> getById(Long id) {
        return roomRepository.findById(id);
    }


    public Room create(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Long id, Room room) {
        room.setId(id);//FIXME will improve later

        return roomRepository.save(room);
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

//    @PostConstruct
//    //FIXME for dev purpose
//    public void loadInitialRooms() {
//        var initialRoomsToAdd = List.of(
//                new RoomDto(null, "zirafa", GIRAFFE, ""),
//                new RoomDto(null, "tigriukas", TIGER, ""),
//                new RoomDto(null, "liutukas", LION, "")
//        );
//
//        initialRoomsToAdd.stream()
//                .map(RoomMapper::toRoom)
//                .forEach(roomRepository::save);
//    }

}
