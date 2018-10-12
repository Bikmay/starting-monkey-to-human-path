package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlTasks {

    static Housekeeper root;

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Housekeeper.class);
        InputStream is = new FileInputStream("xmlTask.xml");
        Unmarshaller um = jc.createUnmarshaller();
        root=(Housekeeper)um.unmarshal(is);


        is.close();
    }

    public double getBill(String street, int buildingNumber,int flatNumber){

        int sum=0;
        for (int i = 0; i <root.buildings.size() ; i++) {
            if (root.buildings.get(i).street.equals(street) && root.buildings.get(i).number==buildingNumber){
                if(root.buildings.get(i).street.equals(street) && root.buildings.get(i).number==buildingNumber){
                    for (int j= 0; i <root.buildings.get(i).flats.size() ; j++) {
                        if(root.buildings.get(i).flats.get(i).number == flatNumber){
                            sum+=root.buildings.get(i).flats.get(j).registrations.get(root.buildings.get(i).flats.get(j).registrations.size()-1).coldwater*root.tariffs.coldwater;
                            sum+=root.buildings.get(i).flats.get(j).registrations.get(root.buildings.get(i).flats.get(j).registrations.size()-1).electricity*root.tariffs.electricity;
                            sum+=root.buildings.get(i).flats.get(j).registrations.get(root.buildings.get(i).flats.get(j).registrations.size()-1).gas*root.tariffs.gas;
                            sum+=root.buildings.get(i).flats.get(j).registrations.get(root.buildings.get(i).flats.get(j).registrations.size()-1).hotwater*root.tariffs.hotwater;
                            return sum;
                        }
                    }
                }
            }
        }

        return 0;
    }

    public void setTarif(String tarifName, double newValue) throws JAXBException, IOException {

        switch (tarifName){
            case "coldwater":
                root.tariffs.setColdwater(newValue);
                break;
            case "hotwater":
                root.tariffs.setHotwater(newValue);
                break;

            case "electricity":
                root.tariffs.setElectricity(newValue);
                break;
            case "gas":
                root.tariffs.setGas(newValue);
                break;
             default:
                 break;
        }
        JAXBContext jc= JAXBContext.newInstance(Housekeeper.class);
        Marshaller m = jc.createMarshaller();
        OutputStream os = new FileOutputStream("text.xml");
        m.marshal(root,os);
        os.close();
    }


    public void addRegistration(String street,int buildingNumber,int flatNumber,int year, int month,double coldWater,double hotWater,double electricity,double gas){

        Registration registration = new Registration(coldWater,hotWater,electricity,gas,month,year);

        for (int i = 0; i <root.buildings.size(); i++) {

        }

    }
}
