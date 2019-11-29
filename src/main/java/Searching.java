import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Searching extends Behaviour {
    public String destination;
    public AgentCfg agentInfo;
    private String currentRoute;
    private double currentLength;
    public boolean Stop = false;

    public Searching(AgentCfg agentInfo) {
        this.agentInfo = agentInfo;
    }

    @Override
    public void action() {
        MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage msg = myAgent.receive(template);
        if (msg!=null) {
            String[] MSG = msg.getContent().split(",");
            destination = msg.getContent().split(",")[0];
            currentRoute = msg.getContent().split(",")[1];
            currentLength = Double.parseDouble(msg.getContent().split(",")[2]);
            int index = msg.getContent().split(",")[1].length()-5;
            if (destination.equals(getAgent().getLocalName())) {
                myAgent.addBehaviour(new theEndOfSearching(MSG[1],MSG[2]));
                Stop = true;
            }
            else if (!msg.getContent().split(",")[1].substring(0,index).contains(getAgent().getLocalName())) {
                getAgent().addBehaviour(new startSearching(destination,currentRoute,currentLength,agentInfo,msg.getSender().getLocalName()));
            }
        }
        else block();
    }

    @Override
    public boolean done() {
        return Stop;
    }
}
