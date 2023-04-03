#language: pt
Funcionalidade: Consulta de CEP

  Cenário: Consultar CEP válido
    Dado que o cliente possui um CEP válido
    Quando o cliente realiza uma consulta no serviço de consulta de CEP
    Então o serviço retorna os dados do endereço correspondente ao CEP consultado
