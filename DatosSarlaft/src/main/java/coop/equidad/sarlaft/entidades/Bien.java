package coop.equidad.sarlaft.entidades;
/**
 * Esta es la uno de las 4 entidades para poder mapear el json del servicio Falabella
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "desc_bien",
    "contratante",
    "asegurado"
})
public class Bien {

    @JsonProperty("desc_bien")
    private String descBien;
    @JsonProperty("contratante")
    private List<Contratante> contratante = null;
    @JsonProperty("asegurado")
    private List<Asegurado> asegurado = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("desc_bien")
    public String getDescBien() {
        return descBien;
    }

    @JsonProperty("desc_bien")
    public void setDescBien(String descBien) {
        this.descBien = descBien;
    }

    @JsonProperty("contratante")
    public List<Contratante> getContratante() {
        return contratante;
    }

    @JsonProperty("contratante")
    public void setContratante(List<Contratante> contratante) {
        this.contratante = contratante;
    }

    @JsonProperty("asegurado")
    public List<Asegurado> getAsegurado() {
        return asegurado;
    }

    @JsonProperty("asegurado")
    public void setAsegurado(List<Asegurado> asegurado) {
        this.asegurado = asegurado;
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
