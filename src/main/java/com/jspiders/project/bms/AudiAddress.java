package com.jspiders.project.bms;
import jakarta.persistence.*;



@Entity
@Table(name = "audi_address")
public class AudiAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//use Auto-Increment
    private Long id;
    @Column(name = "street_name")
    private String streetName;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private Integer pinCode;

    @OneToOne(mappedBy = "audiAddress")
    private Auditorium auditorium;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }
    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}

