package Airport;

public class Aircraft {
    private Integer id;
    private String type;
    private String airlineName;
    private Integer numberOfPassengers;

    public Aircraft(Integer id, String type, String airlineName, Integer numberOfPassengers) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "Aircraft{id=" + id + ", type='" + type + "', airlineName='" + airlineName + "', numberOfPassengers=" + numberOfPassengers + "}";
    }
}