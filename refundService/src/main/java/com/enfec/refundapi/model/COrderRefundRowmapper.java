package com.enfec.refundapi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/************************************************
*
* Author: Heidi Huo
* Assignment: Customer order refund row mapper
* Class: COrderRefundRowmapper
*
************************************************/
public class COrderRefundRowmapper implements RowMapper<COrderRefundTable> {

    /**
     * {@inheritDoc}
     */
    @Override
    public COrderRefundTable mapRow(ResultSet rs, int rowNum) throws SQLException {

        COrderRefundTable cot = new COrderRefundTable();

        cot.setCrefund_id(rs.getInt("CRefund_ID"));
        cot.setCorder_id(rs.getInt("COrder_ID"));
        cot.setCrefund_description(rs.getString("CRefund_Description"));
        cot.setCrefund_updated_time(rs.getTimestamp("CRefund_Updated_Time"));
        cot.setCrefund_status(rs.getString("CRefund_Status"));
        cot.setStripe_status(rs.getString("Customer_Refund.Stripe_Status"));
        cot.setStripe_refund_id(rs.getString("Customer_Refund.Stripe_Refund_ID"));
        
        return cot;
    }
}
