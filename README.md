# Quarkus File validation example

`mvn clean`
`mvn compile quarkus:dev`

## Postgresql configuration

You can configure the sql configuration.

```yaml
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=<your username>
quarkus.datasource.password=<your password>
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:<your postgresql port>/<your postgresql database>
```

### Table used

This project uses a table called `persona` with the following table structure:

```sql
CREATE TABLE persona (
  id BIGINT PRIMARY KEY,
  nombre TEXT NOT NULL,
  edad INTEGER NOT NULL,
  fecha_nacimiento DATE NOT NULL
);
```

# Chain of Responsibility

The part that is using the chain of responsibility is the `validators` folder.

La parte que esta usando el patron de diseño chain of responsibility es la carpeta `validators`.