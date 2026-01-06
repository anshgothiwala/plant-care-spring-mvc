package plantcare.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "services")
public class PlantService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceid;

    private String name;
    private String description;
    private double price;

    // To store uploaded image filename/path
    private String imagePath;

    // One service can have multiple appointments
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // ----- Getters & Setters -----
    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
