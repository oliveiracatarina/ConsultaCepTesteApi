package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ConsultaCepSteps {

    private Response response;

    @Dado("que o cliente possui um CEP válido")
    public void que_o_cliente_possui_um_CEP_válido() {
        RestAssured.baseURI = "https://viacep.com.br/ws/";
    }

    @Quando("o cliente realiza uma consulta no serviço de consulta de CEP")
    public void o_cliente_realiza_uma_consulta_no_serviço_de_consulta_de_CEP() {
        response = RestAssured.given().get("06213080/json/");
    }

    @Então("o serviço retorna os dados do endereço correspondente ao CEP consultado")
    public void o_serviço_retorna_os_dados_do_endereço_correspondente_ao_CEP_consultado() {
        response.then().assertThat().body("cep", equalTo("06213-080"));
    }
}

