package io.github.dearrudam;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;
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
    DataSource dataSource;

    @GET
    @Transactional
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findById(@PathParam("id") final String id) {

        try (
            final var con = dataSource.getConnection();
            final var prepareStatement = con.prepareStatement("select * from devs where id=" + id );
            final var rs = prepareStatement.executeQuery();
            ) {

            var dados = new LinkedList<Map<String, Object>>();
            var rsMetadata = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (var colIndex = 1; colIndex <= rsMetadata.getColumnCount(); colIndex++) {
                    row.put(rsMetadata.getColumnName(colIndex), rs.getObject(colIndex));
                }
                dados.add(row);
            }
            return Response.ok(dados).build();
        } catch (SQLException ex) {
            throw new WebApplicationException(ex, Status.INTERNAL_SERVER_ERROR);
        }
    }

}
