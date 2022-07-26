import java.util.ArrayList;
import java.util.UUID;

public class User{
  UUID userId;
  String name;
  String emailID;

  public User(UUID userId, String name, String emailID) {
    setUserId(UUID.randomUUID()); //generate another UUID in case of duplication
    setName(name); 
    setEmailID(emailID);
  }

  public UUID getUserId() {
    return userId;
  }
  public void setUserId(UUID userId) {
    this.userId = userId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmailID() {
    return emailID;
  }
  public void setEmailID(String emailID) {
    this.emailID = emailID;
  }

  //View balance between this and another user
  public float viewBalance(UUID otherUser){

    List<Expense> allExpenses = new Expense().getAllExpenses();

    float balance;
    for(Expense e : allExpenses){
      // get balance from expenses involving just the 2 users

      // get balance from expenses involving both these users , in which one of these has paid for the expense 
    }

    return balance;
  }


}