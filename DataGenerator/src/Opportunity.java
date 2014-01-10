
/**
 * Created by kkhrebtov on 1/9/14.
 */
public class Opportunity {
    private String eventTs = "",
                   ECD = "",
                   amount = "",
                   name = "",
                   description = "",
                   stageName = "",
                   stageDescription = "",
                   status = "",
                   result = "";

    public Opportunity(String eventTs, String ECD, String amount, String name, String description, String stageName, String stageDescription,String status, String result) {
       this.eventTs = eventTs;
       this.ECD = ECD;
       this.amount = amount;
       this.name = name;
       this.description = description;
       this.stageName = stageName;
       this.stageDescription = stageDescription;
       this.status = status;
       this.result = result;
    }

    public String getEventTs() {return eventTs;}
    public String getECD() {return ECD;}
    public String getAmount() {return amount;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getStageName() {return stageName;}
    public String getStageDescription() {return stageDescription;}
    public String getStatus() {return status;}
    public String getResult() {return result;}


}
