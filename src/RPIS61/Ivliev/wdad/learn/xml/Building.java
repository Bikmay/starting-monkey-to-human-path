package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Building {

    @XmlElement(name = "flat")
    List<Flat> flats;

    @XmlAttribute(name="street")
    String street;

    @XmlAttribute(name="number")
    String number;

    @XmlAttribute(name="flatsquntity")
    int flatsquntity;
}
