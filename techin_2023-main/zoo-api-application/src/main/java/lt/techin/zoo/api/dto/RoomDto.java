package lt.techin.zoo.api.dto;



import java.util.Objects;

public class RoomDto {

    private Long id;
    private String name;
    private String description;

    public RoomDto() {
    }

    public RoomDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(id, roomDto.id) && Objects.equals(name, roomDto.name)  && Objects.equals(description, roomDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,  description);
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
