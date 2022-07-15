package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;
    private static final String DEFAULT_MESSAGE = "Data not available";
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String aName, Employer anEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        this.name = aName;
        this.employer = anEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String getValueFromField(JobField field){
        if(field == null || field.getValue() == "" ) field.setValue(DEFAULT_MESSAGE);
        return field.getValue();
    }
    public String getValueFromField(String name){
        if(name == null || name == "") name = DEFAULT_MESSAGE;
        return name;
    }


    @Override
    public String toString() {
        String value = "";
        if((getName() == null || getName()=="") && getEmployer() == null && getLocation() == null && getPositionType() == null && getCoreCompetency() == null){
            return "\nOOPS! This job does not exist.\n";
        }
        value =  String.format("\n" +
                        "ID: %s\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",
                id == 0? DEFAULT_MESSAGE : id,
                getValueFromField(name),
                getValueFromField(employer),
                getValueFromField(location),
                getValueFromField(positionType),
                getValueFromField(coreCompetency));

        return value;
//                "\n" +
//                "\nid=" + id + "\nname=" + name + "\nemployer=" + employer + "\nlocation=" + location + "\npositionType=" + positionType + "\ncoreCompetency=" + coreCompetency +
//                "\n";
    }

//    @Override
//    public String toString() {
//        return "\nJob{ "\n id=" + id + ",\nname=" + name +
//            ", \nemployer=" + employer +
//            ", \nlocation=" + location +
//            ", \npositionType=" + positionType +
//            ", \ncoreCompetency=" + coreCompetency
//                      }\n";
//    }
}
