import java.util.Map;

public class Gym {
  private final int totalGymMembers;
  private Map<MachineType, Integer> availableMachines;

  public Gym(int totalGymMembers, Map<MachineType, Integer> availableMachines){
    this.totalGymMembers = totalGymMembers;
    this.availableMachines = availableMachines;
  }
}
