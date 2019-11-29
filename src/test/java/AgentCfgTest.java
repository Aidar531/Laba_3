import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AgentCfgTest {
    private ArrayList<neighbour> ListOfNeighbours = new ArrayList<neighbour>();
    @Test
    public void cfgTest(){

        neighbour N1 = new neighbour("1", 2), N2 = new neighbour("2", 5);
        ListOfNeighbours.add(N1);
        ListOfNeighbours.add(N2);
        AgentCfg a = new AgentCfg();
        a.setNeighbours(ListOfNeighbours);
        a.setNodeName("3");
        a.setDestination("2");
        //a.setAmITheFirst(true);

//        WorkWithXml.marshalAny(AgentCfg.class ,a,"First.xml");

        AgentCfg agentCfg = WorkWithXml.unMarshalAny(AgentCfg.class, "Node1.xml");

        System.out.println(agentCfg.getNeighbours().get(1).getWeight());

//        AgentCfg expected = new AgentCfg();
//        expected.setNodeName("3");
//        expected.setNeighbours(new ArrayList<>());
//        expected.getNeighbours().add(new neighbour("1",2));
//        expected.getNeighbours().add(new neighbour("2",2));
//
//        Assert.assertEquals(expected,agentCfg);
    }

}