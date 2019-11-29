import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Arrays;

public class waitingFordestination extends Behaviour {
    public double minLength = Double.MAX_VALUE;
    public String bestRoute;
    @Override
    public void action() {
        MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
        ACLMessage msg = myAgent.receive(template);
        if (msg!=null) {
            if (Double.parseDouble(msg.getContent().split(",")[1]) < minLength) {
                minLength = Double.parseDouble(msg.getContent().split(",")[1]);
                bestRoute = msg.getContent().split(",")[0];
                System.out.println("Минимальное расстояние: " + minLength);
                System.out.println("Минимальное  маршрут: " + bestRoute);
            }
        }
        else block();
    }

    @Override
    public boolean done() {
        return false;
    }
}
