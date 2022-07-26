import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Group {
  UUID groupId;
  String name;
  String description;
  UUID createdBy;
  Date createdOn;
  List<UUID> users;

  public Group(UUID createdBy, Date createdOn) {
    this.groupId = UUID.randomUUID(); //generate another UUID in case of duplication
    this.createdBy = createdBy;
    this.createdOn = createdOn;
  }

  public Group(UUID createdBy, Date createdOn, String name) {
    Group(createdBy, createdOn);
    setName(name);
  }

  public Group(UUID createdBy, Date createdOn, String name, String description) {
    Group(createdBy, createdOn, name);
    setDescription(description);
  }

  public Group(UUID createdBy, Date createdOn, String name, String description, List<UUID> users) {
    Group(createdBy, createdOn, name, description);
    this.users = users;
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

  public void addUser(User user) {
    users.add(user.userId);
  }

  public void removeUser(User user) {
    users.remove(user.userId);
    return user;
  }

  public void settleAllGroupExpenses() {
    List<Expense> allExpenses =  new Expense().getAllExpenses();
    List<Expense> groupExpenses = new ArrayList<>();
    //get a list of all expenses involving this group
    for(Expense expense : allExpenses){
      if(expense.groupId==this.groupId)
        groupExpenses.add(expense);
    }

    //settle each expense
    for(Expense expense :  groupExpenses){
      expense.settleExpense();
    }
  }

  
}
