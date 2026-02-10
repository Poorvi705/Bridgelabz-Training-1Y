package com.gla.string;
public class DynamicSQLQueryBuilder {

    private StringBuilder query;
    private boolean hasWhere = false;
    private boolean hasOrderBy = false;
    private boolean hasSelect = false;

    public DynamicSQLQueryBuilder() {
        query = new StringBuilder();
    }

    // Add SELECT column
    public void addSelectColumn(String column) {
        if (!hasSelect) {
            query.append("SELECT ");
            hasSelect = true;
        } else {
            query.append(", ");
        }
        query.append(column);
    }

    // Add FROM clause
    public void addFrom(String table) {
        query.append("\nFROM ").append(table);
    }

    // Add JOIN clause
    public void addJoin(String table, String condition) {
        query.append("\nJOIN ").append(table)
                .append(" ON ").append(condition);
    }

    // Add WHERE condition
    public void addWhereCondition(String condition, String operator) {
        if (!hasWhere) {
            query.append("\nWHERE ");
            hasWhere = true;
        } else {
            query.append(" ").append(operator).append(" ");
        }
        query.append(condition);
    }

    // Add ORDER BY clause
    public void addOrderBy(String column, String direction) {
        if (!hasOrderBy) {
            query.append("\nORDER BY ");
            hasOrderBy = true;
        } else {
            query.append(", ");
        }
        query.append(column).append(" ").append(direction);
    }

    // Set LIMIT
    public void setLimit(int limit) {
        query.append("\nLIMIT ").append(limit);
    }

    // Build final query
    public String build() {
        return query.toString();
    }

    // Main method for testing
    public static void main(String[] args) {

        DynamicSQLQueryBuilder builder = new DynamicSQLQueryBuilder();

        // SELECT columns (5+)
        builder.addSelectColumn("u.id");
        builder.addSelectColumn("u.name");
        builder.addSelectColumn("u.email");
        builder.addSelectColumn("o.order_id");
        builder.addSelectColumn("o.amount");

        // FROM
        builder.addFrom("users u");

        // JOIN
        builder.addJoin("orders o", "u.id = o.user_id");

        // WHERE conditions (3+)
        builder.addWhereCondition("u.active = 1", "AND");
        builder.addWhereCondition("o.amount > 500", "AND");
        builder.addWhereCondition("u.country = 'India'", "OR");

        // ORDER BY (2 columns)
        builder.addOrderBy("o.amount", "DESC");
        builder.addOrderBy("u.name", "ASC");

        // LIMIT
        builder.setLimit(100);

        // Final Query
        String finalQuery = builder.build();

        System.out.println("======= FINAL SQL QUERY =======");
        System.out.println(finalQuery);

        System.out.println("\nQuery Length: " + finalQuery.length());
    }
}