package bytefruit;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FAKTURA {

	protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    public static void main(String[] args) {
        // ID del pedido para el que se genera la factura
        String pedidoId = "123"; // ¡Asegúrate de cambiarlo por un ID válido de la tabla!

        // Generar la factura
        generarFactura(pedidoId);
    }

    private static void generarFactura(String pedidoId) {
        String nombreArchivo = "factura.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo));
             Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Consulta SQL para obtener los datos de la factura
            String query = "SELECT ID, NAN, egoera, pedidoEguna FROM eskaerak WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pedidoId);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Escribir los datos de la factura en el archivo
            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("cliente_nombre");
                String direccionCliente = resultSet.getString("direccion_cliente");
                double totalFactura = resultSet.getDouble("total_factura");
                String productos = resultSet.getString("productos");

                // Escribir encabezado
                writer.println("FACTURA");
                writer.println("Nombre del cliente: " + nombreCliente);
                writer.println("Dirección del cliente: " + direccionCliente);
                writer.println("------------------------------");
                writer.println("Productos:");
                writer.println(productos);
                writer.println("------------------------------");
                writer.println("Total: $" + totalFactura);

                System.out.println("Factura generada correctamente como: " + nombreArchivo);
            }
        } catch (IOException | SQLException e) {
            System.err.println("Error al generar la factura: " + e.getMessage());
        }
    }
}
