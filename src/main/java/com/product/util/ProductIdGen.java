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

public class ProductIdGen implements IdentifierGenerator {

    /**
     * The Logger
     */
    final Logger logger = LoggerFactory.getLogger(ProductIdGen.class);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "proId";
        Connection connection = session.connection();

        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("select count(productId) as productId from product");

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