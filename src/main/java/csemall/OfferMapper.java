package csemall;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jihun on 2017. 2. 12..
 */
public class OfferMapper implements RowMapper<Offer> {
    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Offer offer = new Offer();
        offer.setId(rs.getInt("id"));
        offer.setName(rs.getString("name"));
        offer.setEmail(rs.getString("email"));
        offer.setText(rs.getString("text"));

        return offer;
    }
}
