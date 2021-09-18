package io.github.dearrudam;

import io.agroal.api.AgroalDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/rows")
public class DevelopersResource {
    @Inject
    AgroalDataSource dataSource;

    @GET
    @Path("{id}")
    @Produces({
        MediaType.APPLICATION_JSON
    })
    public Response findById(
        @PathParam("id") final String id
    ) {
        try (
            final var con = dataSource.getConnection();
            final var prepareStatement = con.prepareStatement(
                "select id, nome, nivel from devs where id='" + id + "'"
            );
            final var rs = prepareStatement.executeQuery();
        ) {
            var dados = new LinkedList<Map<String, String>>();
            while (rs.next()) {
                dados.add(
                    Map.of(
                        "id", rs.getString("id"),
                        "nome", rs.getString("nome"),
                        "nivel", rs.getString("nivel")
                    )
                );
            }
            return Response.ok(dados).build();
        } catch (SQLException ex) {
            throw new WebApplicationException(
                ex,
                Status.INTERNAL_SERVER_ERROR
            );
        }
    }

    private PreparedStatement createPreparedStatement(
        final String id,
        final Connection con
    )
        throws SQLException {
        final var prepareStatement = con.prepareStatement(
            "select id, nome, nivel from devs where id=?"
        );
        prepareStatement.setString(1, id);
        return prepareStatement;
    }
}
