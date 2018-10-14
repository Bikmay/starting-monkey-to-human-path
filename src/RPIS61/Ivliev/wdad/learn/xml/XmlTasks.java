package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class XmlTasks {




     public static void main(String[] args) throws JAXBException, IOException {
        Housekeeper housekeeper = Housekeeper.getRoot();

        housekeeper.setTarif("gas",2);
         System.out.println(TestXmlTask.testSetTariffs("gas",2));

         housekeeper.setTarif("hotwater",2);
         housekeeper.setTarif("coldwater",2);
         housekeeper.setTarif("electricity",2);

       //  housekeeper.addRegistration("Panova",64,98,2018,3,23,23,23,23);
         //housekeeper.addRegistration("Panova",64,98,2018,4,24,24,24,24);

         System.out.println(TestXmlTask.testAddRegistrartion("Panova",64,98,2018,3));

         System.out.println(TestXmlTask.testGetBill(housekeeper.getBill("Panova",64,98),8));
         System.out.println(housekeeper.getBill("Panova",64,98));

     }



}
