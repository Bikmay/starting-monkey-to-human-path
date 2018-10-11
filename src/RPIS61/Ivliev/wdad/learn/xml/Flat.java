package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Flat {

    @XmlElement(name="registration")
    List<Registration> registrations;

    @XmlAttribute(name="number")
    int number;

    @XmlAttribute(name="personsquantity")
    int personsquantity;

    @XmlAttribute(name="area")
    int area;
}
