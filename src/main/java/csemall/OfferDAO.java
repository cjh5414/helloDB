package csemall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jihun on 2017. 2. 12..
 */
@Component
public class OfferDAO {

    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement = "select count(*) from offers";
        return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
    }

    // querying and returning a single object
    public Offer getOffer(String name) {
        String sqlStatement = "select * from offers where name=?";

        return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{name}, new OfferMapper());
    }

    public List<Offer> getOffers() {
        String sqlStatement = "select * from offers";

        return jdbcTemplateObject.query(sqlStatement, new OfferMapper());
    }

    public boolean insert(Offer offer) {
        String sqlStatement = "insert into offers (name, email, text) values (?,?,?)";

        String name = offer.getName();
        String email = offer.getEmail();
        String text = offer.getText();

        return (jdbcTemplateObject.update(sqlStatement, new Object[]{name, email, text}) == 1);
    }

    public boolean update(Offer offer) {
        String sqlStatement = "update offers set name=?, email=?, text=? where id=?";

        int id = offer.getId();
        String name = offer.getName();
        String email = offer.getEmail();
        String text = offer.getText();

        return (jdbcTemplateObject.update(sqlStatement, new Object[]{name, email, text, id}) == 1);
    }

    public boolean delete(int id) {
        String sqlStatement = "delete from offers where id=?";

        return (jdbcTemplateObject.update(sqlStatement, new Object[]{id})==1);
    }
}
