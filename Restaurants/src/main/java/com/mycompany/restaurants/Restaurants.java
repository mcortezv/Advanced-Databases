/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurants;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Cortez, Manuel;
 */
public class Restaurants {

    public static void main(String[] args) {

        // Lo conecte con Atlas en el navegador por eso esta distinto a como nos enseño
        String connectionString = "mongodb+srv://root:1234@cluster0.ivbngms.mongodb.net/?appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                MongoDatabase database = mongoClient.getDatabase("restaurants");
                MongoCollection<Document> col = database.getCollection("restaurants");
                ArrayList<Document> lista = new ArrayList<>();


                lista.add(new Document("name", "Café de la plaza")
                        .append("stars", 4.3)
                        .append("categorias", Arrays.asList(new String[]{"Café", "Postres", "Desayuno"}))
                );
                lista.add(new Document("name", "Espresso Express")
                        .append("stars", 4.8)
                        .append("categorias", Arrays.asList(new String[]{"Café","Rápido","Takeaway"}))
                );
                lista.add(new Document("name", "The Tea House")
                        .append("stars", 3.9)
                        .append("categorias", Arrays.asList(new String[]{"Té","Infusiones","Postres"}))
                );
                lista.add(new Document("name", "Morning Brew")
                        .append("stars", 4.0)
                        .append("categorias", Arrays.asList(new String[]{"Café","Desayuno","Bakery"}))
                );
                col.insertMany(lista);
                System.out.println("Documentos Agregados");

                System.out.println("Documentos con stars >= 4.5");
                for(Document d: col.find(Filters.gte("stars", 4))){
                    System.out.println(d.toJson());
                }

                System.out.println("Documentos cuyo nombre contiene Café");
                for(Document d: col.find(Filters.eq("name", "Café"))){
                    System.out.println(d.toJson());
                }

                System.out.println("Documentos con categories que incluyan Postres");
                for(Document d: col.find(Filters.eq("categorias", "Postres"))){
                    System.out.println(d.toJson());
                }

                System.out.println("Documentos con stars entre 3 y 4.3");
                Bson filtro = Filters.and(Filters.gte("stars", 3), Filters.lte("stars", 4.3));
                for (Document d: col.find(filtro)){
                    System.out.println(d.toJson());
                }

                System.out.println("Documentos cuyo nombre empieza con T");
                for (Document d: col.find(Filters.regex("name", "^T"))){
                    System.out.println(d.toJson());
                }

                // Updates --------------------------------------------------------------------------------------------

                // Cambiar stars a 4.5 para "Morning Brew".
                col.updateOne(Filters.eq("name", "Morning Brew"), Updates.set("stars", 4.5));

                // Incrementar stars +0.2 para documentos con categories que contenga "Bakery" o "Desayuno".
                col.updateMany(Filters.in("categorias", Arrays.asList("Takeaway", "Infusiones")), Updates.inc("stars", 0.2));

                // Agregar campos phone = "555-111-2222" y open = true a "Café de la Plaza".
                col.updateOne(Filters.eq("name", "Café de la Plaza"), Updates.combine(
                        Updates.set("phone", "555-111-2222"),
                        Updates.set("open", true)
                ));

                // Deletion -------------------------------------------------------------------------------------------

                // Eliminar documento con name = "Espresso Express".
                col.deleteOne(Filters.eq("name", "Espresso Express"));

                // Eliminar todos los documentos con stars < 4.
                col.deleteMany(Filters.eq(Filters.lt("stars", 4)));

                // Eliminar documentos con categories que contengan "Takeaway" o "Infusiones".
                col.deleteMany(Filters.in("categorias", Arrays.asList("Takeaway", "Infusiones")));

            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}>
