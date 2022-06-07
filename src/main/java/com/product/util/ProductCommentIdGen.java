package com.product.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductCommentIdGen implements IdentifierGenerator {

    /**
     * The Logger
     */
    final Logger logger = LoggerFactory.getLogger(ProductCommentIdGen.class);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "procmntid";
        Connection connection = session.connection();

        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("select count(productcmntid) as productcmntid from productcomment");

            if (rs.next()) {
                int id = rs.getInt(1) + 01;
                String generatedId = prefix + id;
                logger.info("Generated Id: {}", generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}