package timetable.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "group_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_number", unique = true)
    private Integer number;

    @Column(name = "group_name")
    private String name;

    public Group() {
    }

    public Group(Long id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2){
            System.out.println("Довжина спеціальності некоректна");
        }
        if (name.length() > 40){System.out.println("Довжина спеціальності некоректна");}
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return number == group.number &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
