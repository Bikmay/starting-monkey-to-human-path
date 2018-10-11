package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gen")
public class Housekeeper {

    @XmlElement(name="building")
    Building building;



}
