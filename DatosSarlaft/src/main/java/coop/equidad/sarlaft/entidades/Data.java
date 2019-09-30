package coop.equidad.sarlaft.entidades;
/**
 * Esta es la uno de las 4 entidades para poder mapear el json del servicio Falabella
 */
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "numero_propuesta",
    "fecha_consulta",
    "compania",
    "bien"
})
public class Data {

    @JsonProperty("numero_propuesta")
    private String numeroPropuesta;
    @JsonProperty("fecha_consulta")
    private String fechaConsulta;
    @JsonProperty("compania")
    private String compania;
    @JsonProperty("bien")
    private Bien bien;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("numero_propuesta")
    public String getNumeroPropuesta() {
        return numeroPropuesta;
    }

    @JsonProperty("numero_propuesta")
    public void setNumeroPropuesta(String numeroPropuesta) {
        this.numeroPropuesta = numeroPropuesta;
    }

    @JsonProperty("fecha_consulta")
    public String getFechaConsulta() {
        return fechaConsulta;
    }

    @JsonProperty("fecha_consulta")
    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    @JsonProperty("compania")
    public String getCompania() {
        return compania;
    }

    @JsonProperty("compania")
    public void setCompania(String compania) {
        this.compania = compania;
    }

    @JsonProperty("bien")
    public Bien getBien() {
        return bien;
    }

    @JsonProperty("bien")
    public void setBien(Bien bien) {
        this.bien = bien;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
