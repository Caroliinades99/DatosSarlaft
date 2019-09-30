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
@JsonPropertyOrder({ "CODIGO", "VALOR", "DESCRIPCION" })
public class Contratante {

	@JsonProperty("CODIGO")
	private String codigo;
	@JsonProperty("VALOR")
	private String valor;
	@JsonProperty("DESCRIPCION")
	private String descripcion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("CODIGO")
	public String getCodigo() {
		return codigo;
	}

	@JsonProperty("CODIGO")
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@JsonProperty("VALOR")
	public String getValor() {
		return valor;
	}

	@JsonProperty("VALOR")
	public void setValor(String valor) {
		this.valor = valor;
	}

	@JsonProperty("DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}

	@JsonProperty("DESCRIPCION")
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
