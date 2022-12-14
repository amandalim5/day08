package myapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Place {
  private String room;
  private String name;
  private String description;
  private Map<String, String> directions = new HashMap<>();
  
  public String getRoom() {
    return room;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Map<String, String> getDirections() {
    return directions;
  }


  public Place(String room, String name, String description, Map<String, String> directions) {
    this.room = room;
    this.name = name;
    this.description = description;
    this.directions = directions;
  }

  

  
}
