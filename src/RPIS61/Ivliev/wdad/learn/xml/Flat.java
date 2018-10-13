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


    public Registration getRegistration(int index){
        return this.registrations.get(index);
    }

    public Registration getLastRegistration(){
        return this.registrations.get(registrations.size()-1);
    }

    public void setNewRegistration(double coldwater,double hotwater,double electricity,double gas, int month,int year){
        registrations.add(new Registration(coldwater,hotwater,electricity,gas,month,year));
    }

}
