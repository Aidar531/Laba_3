import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.util.stream.Collectors;

public class startSearching extends OneShotBehaviour {
    public String currentRoute;
    public double currentLength;
    public String destination;
    public AgentCfg agentInfo;
    public String previousSender;

    public startSearching(String destination,String currentRoute, double currentLength, AgentCfg agentInfo,String previousSender) {
        this.currentRoute = currentRoute;
        this.currentLength = currentLength;
        this.destination = destination;
        this.agentInfo = agentInfo;
        this.previousSender = previousSender;
    }

    @Override
    public void action() {
        for (neighbour X: agentInfo.getNeighbours()) {
            if (!X.getNodeName().equals(previousSender)) {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID(X.getNodeName(), false));
                double Length = currentLength + X.getWeight();
                msg.setContent(destination + "," + currentRoute + "-" +X.getNodeName() + "," + Length);
                myAgent.send(msg);
            }
        }
    }
}
