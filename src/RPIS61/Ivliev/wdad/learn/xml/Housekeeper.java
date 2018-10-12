package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "gen")
public class Housekeeper {

    @XmlElement(name = "tariffs")
    Tariffs tariffs;

    @XmlElement(name="building")
    List<Building> buildings;


public Housekeeper(){

}


}
