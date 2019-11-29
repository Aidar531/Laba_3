import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class theEndOfSearching extends OneShotBehaviour {

    public String route;
    public String length;

    public theEndOfSearching(String route, String length) {
        this.route = route;
        this.length = length;
    }

    @Override
    public void action() {
        ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
        msg.setContent(route+","+length);
        AID aid = new AID(route.substring(0,5),false);
        msg.addReceiver(aid);
        myAgent.send(msg);
    }
}
