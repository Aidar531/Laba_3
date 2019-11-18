import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class neighbour {
    @XmlAttribute
    private String nodeName;
    @XmlAttribute
    private double weight;

    public neighbour(String nodeName, double weight) {
        this.nodeName = nodeName;
        this.weight = weight;
    }

    public neighbour() {
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        neighbour neighbour = (neighbour) o;
        return Double.compare(neighbour.weight, weight) == 0 &&
                Objects.equals(nodeName, neighbour.nodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeName, weight);
    }

    @Override
    public String toString() {
        return "neighbour{" +
                "nodeName='" + nodeName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
