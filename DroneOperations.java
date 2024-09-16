package nguyen.INTERFACES;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import nguyen.CLASSES.ImperialDrone;

public interface DroneOperations {
	public static final String dir = "/Nguyen_NYU_HW6/src/nguyen/STORAGE/";
	public static final String dir2 = "/Nguyen_NYU_HW6/src/nguyen/DATA/";
	
	public default void storeDrone(String filename, ImperialDrone drone) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dir + filename))) {
            out.writeObject(drone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public default ImperialDrone retrieveDrone(String filename) {
        ImperialDrone drone = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dir + filename))) {
            drone = (ImperialDrone) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drone;
    }
	
	public static TreeMap<String, ImperialDrone> buildAllDrones(String filename){
        return new TreeMap<>();
	}
}
