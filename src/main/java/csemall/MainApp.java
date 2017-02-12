package csemall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by jihun on 2017. 2. 12..
 */
public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");

        OfferDAO offerDAO = (OfferDAO)context.getBean("offerDAO");
        System.out.println(offerDAO.getRowCount());

        List<Offer> offerList = offerDAO.getOffers();
        for(Offer offer: offerList) {
            System.out.println(offer);
        }

        Offer offer = new Offer("cjh5414@gmail.com", "jihun", "an instructor of spring framework");
        if(offerDAO.insert(offer)) {
            System.out.println("Object is inserted successfully");
        }
        else {
            System.out.println("Object insertion failed");
        }

        offer = offerDAO.getOffer("jihun");
        System.out.println(offer);

        offer.setName("Choi jihun");
        if(offerDAO.update(offer))
            System.out.println("update with name" + offer);
        else
            System.out.println("Cannot update an object");

        if(offerDAO.delete(offer.getId()))
            System.out.println("Object is deleted");
        else
            System.out.println("cannot delete object");

        context.close();
    }
}
