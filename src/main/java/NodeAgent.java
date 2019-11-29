import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

public class NodeAgent extends Agent {

    @Override
    protected void setup() {

        getStarted();

    }

    private void getStarted() {
        AgentCfg agentInfo = WorkWithXml.unMarshalAny(AgentCfg.class, getLocalName() + ".xml");
        if (agentInfo.amITheFirst()) {
            addBehaviour(new startSearching(agentInfo.getDestination(),getLocalName(),0,agentInfo,null));
            addBehaviour(new waitingFordestination());
        }
        else {
            addBehaviour(new Searching(agentInfo));
        }
    }
}
