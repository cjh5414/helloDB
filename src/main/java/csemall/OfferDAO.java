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

        return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{name}, new RowMapper<Offer>() {
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();
                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setEmail(rs.getString("email"));
                offer.setText(rs.getString("text"));

                return offer;
            }
        });
    }

    public List<Offer> getOffers() {
        String sqlStatement = "select * from offers";

        return jdbcTemplateObject.query(sqlStatement, new RowMapper<Offer>() {
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();
                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setEmail(rs.getString("email"));
                offer.setText(rs.getString("text"));

                return offer;
            }
        });
    }
}
