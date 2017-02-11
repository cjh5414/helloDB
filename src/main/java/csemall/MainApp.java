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
        context.close();
    }
}
