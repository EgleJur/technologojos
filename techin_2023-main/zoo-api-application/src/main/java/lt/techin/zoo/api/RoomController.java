package lt.techin.zoo.api;

import lt.techin.zoo.api.dto.RoomDto;
import lt.techin.zoo.api.dto.mapper.RoomMapper;
import lt.techin.zoo.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.zoo.api.dto.mapper.RoomMapper.toRoom;
import static lt.techin.zoo.api.dto.mapper.RoomMapper.toRoomDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    @ResponseBody
    public List<RoomDto> getRooms() {
        return roomService.getAll().stream()
                .map(RoomMapper::toRoomDto)
                .collect(toList());
        //return ResponseEntity.ok(roomRepository.getAll());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable Long roomId) {
        var roomOptional = roomService.getById(roomId);

        var responseEntity = roomOptional
                .map(room -> ok(toRoomDto(room)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) {
        roomService.deleteById(roomId);

        return ResponseEntity.noContent().build();
        //return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //TODO create
    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto) {
        //FIXME temp
        roomDto.setId(null);

        var createdRoom = roomService.create(toRoom(roomDto));

        return ok(toRoomDto(createdRoom));
    }

    //TODO update

    @PutMapping("/{roomId}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long roomId, @RequestBody RoomDto roomDto) {
        //FIXME temp
        roomDto.setId(null);

        var updatedRoom = roomService.update(roomId, toRoom(roomDto));

        return ok(toRoomDto(updatedRoom));
    }

}
