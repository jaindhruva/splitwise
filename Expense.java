import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Expense {
  UUID expenseId;
  String title;
  String description;
  float amount;
  UUID createdBy;
  UUID paidBy;
  Date createdOn;
  UUID groupId;
  SplitByType splitByType;
  boolean isSettled;
  


  public addExpense(String title, float amount, UUID createdBy, UUID paidBy, Date createdOn) {
    setExpenseId(UUID.randomUUID()); //generate another UUID in case of duplication
    setTitle(title);
    setAmount(amount); 
    setCreatedBy(createdBy);
    setPaidBy(paidBy);
    setCreatedOn(createdOn);
    unsettleExpense();
  }

  public UUID getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(UUID expenseId) {
    this.expenseId = expenseId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public UUID getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(UUID createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UUID getGroupId() {
    return groupId;
  }

  public void setGroupId(Group group) {
    this.groupId = group.groupId;
  }

  public SplitByType getSplitByType() {
    return splitByType;
  }

  public void setSplitByType(SplitByType splitByType) {
    this.splitByType = splitByType;
  }

  public boolean getSettleStatus() {
    return this.isSettled;
  }

  public UUID getPaidBy() {
    return paidBy;
  }

  public void setPaidBy(User user) {
    this.paidBy = user.userId;
  }

  public void unsettleExpense() {
    this.isSettled = false;
  }

  public void settleExpense() {
    
    List<UserExpenseSplit> allUserExpenseSplits =  new UserExpenseSplit().getAllUserExpenseSplits();

    HashMap<User, User> usersExpenseSplitMap = new HashMap<>();
    for(UserExpenseSplit userExpenseSplit : allUserExpenseSplits){
      // go through all userExpenseSplits , and populate map with all users involved in this expense.
      // add logic to avoid duplication of entries
    }
    
    for(User user1 : usersExpenseSplitMap.keySet()){
      int balance = user1.viewBalance(usersExpenseSplitMap.get(user1));
      //call payment gateway API and pass the balance as the payment
      //payment request to be made to the user who OWES money and not to user who is OWED money.
    }

    this.isSettled = true;
  }

  public List<Expense> getAllExpenses(){
    List<Expense> allExpenses = new ArrayList<>();
    //populate this list of allExpenses
    return allExpenses;
  }

}

enum SplitByType{
  EQUAL,
  UNEQUAL,
  PERCENTAGE
}