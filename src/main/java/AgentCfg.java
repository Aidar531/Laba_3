import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "agentCfg")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentCfg {
    @XmlElement
    private String NodeName;
    @XmlElement
    private boolean amITheFirst=false;

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    @Override
    public String toString() {
        return "AgentCfg{" +
                "NodeName='" + NodeName + '\'' +
                ", amITheFirst=" + amITheFirst +
                ", Destination='" + Destination + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }

    @XmlElement
    private String Destination;
    @XmlElementWrapper(name="neighbours")
    @XmlElement(name = "neighbour")
    private List<neighbour> neighbours;

    public String getNodeName() {
        return NodeName;
    }

    public List<neighbour> getNeighbours() {
        return neighbours;
    }

    public void setNodeName(String nodeName) {
        NodeName = nodeName;
    }

    public void setNeighbours(List<neighbour> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentCfg agentCfg = (AgentCfg) o;
        return Objects.equals(NodeName, agentCfg.NodeName) &&
                Objects.equals(neighbours, agentCfg.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NodeName, neighbours);
    }

    public boolean isAmITheFirst() {
        return amITheFirst;
    }

    public void setAmITheFirst(boolean amITheFirst) {
        this.amITheFirst = amITheFirst;
    }
}
