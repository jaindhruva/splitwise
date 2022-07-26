import java.util.ArrayList;
import java.util.UUID;

public class UserExpenseSplit {
  UUID userExpenseSplitId;
  UUID expenseId;
  UUID userId;
  float splitAbsolute;

  public void addExpenseSplit(UUID expenseId, UUID userId, float splitAbsolute ) {
    this.userExpenseSplitId = UUID.randomUUID(); //generate another UUID in case of duplication
    this.expenseId = expenseId;
    this.userId = userId;
    this.splitAbsolute = splitAbsolute;
  }

  public void modifySplitAbsolute(float splitAbsolute) {
    this.splitAbsolute =  splitAbsolute;
  }

  public List<UserExpenseSplit> getAllUserExpenseSplits(){
    List<UserExpenseSplit> allUserExpenseSplits = new ArrayList<>();
    //populate this list
    return allUserExpenseSplits;
  }
  
}
