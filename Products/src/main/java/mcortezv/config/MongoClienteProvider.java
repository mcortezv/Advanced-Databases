package mcortezv.config;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public enum MongoClienteProvider {
    INSTANCE;

    private MongoClient client;
    private String dbName  = "ProductsDB";
    private String uri = "eliminado para no versionar";

    public synchronized void init(){
        if (client == null) {
            client = MongoClients.create(MongoConfig.buildSettings(this.uri));
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try { client.close(); } catch (Exception ignored) {}
            }));
        }
    }
    public MongoClient client() {
        if (client == null) throw new IllegalStateException("MongoClientProvider no inicializado. Llama a init(uri) antes.");
        return client;
    }

    public MongoDatabase database() {
        return client().getDatabase(this.dbName);
    }

    public <T> MongoCollection<T> getCollection(String collectionName, Class<T> tclass) {
        if (client == null)
            throw new IllegalStateException("MongoClientProvider no inicializado. Llama a init(uri) antes.");
        MongoDatabase db = client.getDatabase(this.dbName);
        return db.getCollection(collectionName, tclass);
    }
}
