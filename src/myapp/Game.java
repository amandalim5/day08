package myapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    String fileName = args[0];
    List<String> dataList = new ArrayList<>();
    // List<Place> rooms = new ArrayList<>();
    Map<String, Place> rooma = new HashMap<>();

    try{
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while((line = br.readLine()) != null){
        dataList.add(line);
      }
    } catch (IOException e){
      e.printStackTrace();
    }

    // split the array lists according to the place

    String currentRoom="";
    String currentName="";
    String currentDescription="";
    String standingHere="";
    Map<String, String> currentDirections = new HashMap<>();
    for(String w: dataList){
      // System.out.println(w);
      if(w.startsWith("room:")){
        currentRoom = w.substring(6);
        // System.out.println(currentRoom + " is assigned");
      } else if(w.startsWith("name:")){
        currentName = w.substring(6);
        // System.out.println(currentName + "is assigned");
      } else if(w.startsWith("description:")){
        currentDescription = w.substring(13);
        // System.out.println("description: " + currentDescription);
      } else if(w. startsWith("direction")){
        String[] pair = w.split(" ");
        currentDirections.put(pair[1], pair[2]);
      } else if(w.isBlank()){
        Place place = new Place(currentRoom, currentName, currentDescription, currentDirections);
        // rooms.add(place);
        rooma.put(currentRoom, place);
        currentDirections = new HashMap<>();    
      } else if(w.startsWith("start")){
        standingHere = w.substring(7);
      }

      
    }

    // for(Place place:rooms){
    //   System.out.println(place.getName());
    //   System.out.println(place.getDescription());
    //   Map<String, String> dir = place.getDirections();
    //   System.out.println("size:" + dir.size());
    //   for(String key: dir.keySet()){
    //     System.out.println(key + " -->" + dir.get(key));
    //   }
    //   System.out.println(place.getDirections().get("north"));
    // }

    System.out.printf("You are currently in %s\n>",standingHere);
    Scanner scanner = new Scanner(System.in);
    String command = "";
    while(true){
      command = scanner.nextLine().trim().toLowerCase();

      if(command.equals("look")){
        System.out.printf("You are currently in %s\n>",standingHere);
        String[] desc = rooma.get(standingHere).getDescription().split("<break>");
        for(int i=0; i<desc.length; i++){
          System.out.println(desc[i]);
        }

      } else if(command.equals("exit")){
        System.out.println("Have a good day!");
        break;
      } else if(command.equals("north")|| command.equals("south") || command.equals("east")|| command.equals("west")){
        String newplace = rooma.get(standingHere).getDirections().get(command);
        if(newplace == null){
          System.out.println("You cannot go there! you shall remain in " + standingHere);
        } else{
          System.out.println("You were in " + standingHere + " and now you are in " + newplace);
          standingHere = newplace;
          String[] desc = rooma.get(standingHere).getDescription().split("<break>");
          for(int i=0; i<desc.length; i++){
            System.out.println(desc[i]);
          }
        }

      }
    }





    // directions for each place is a hashmap, since each key will be unique


  }
}
