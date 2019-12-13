### JRastreamento-correios
Biblioteca em java para o rastreamento de objetos
* Faz web scrap na pagina de rastreamento do correios [linkcorreios](https://www.linkcorreios.com.br/ "Correios")

### Download
JRastreamentoCorreios-1.0-SNAPSHOT.jar [Download](https://github.com/gabriellhuver/JRastreamento-correios/blob/master/target/JRastreamentoCorreios-1.0-SNAPSHOT.jar "JRastreamento correios")

### Como usar
A API tem só um método, rastreamento.Rastrear("CODIGO"), ele retorna um rastreamento contendo uma lista de status, ordenado do mais antigo para o mais atual.
```java
RastreamentoAPI rastreamento =  new RastreamentoAPI();
	try {
		Rastreamento Rastrear = rastreamento.Rastrear("BR11111111BR");
		for (Status status : Rastrear.getStatusList()) {
			 System.out.println(status.toString());
		}
	} catch (Exception ex) {}
```
#### Observação
Eu gostaria de publicar via maven, se alguem puder me ajudar com isso! Obrigado

### Autor
[Gabriell Huver](https://github.com/gabriellhuver/ "Gabriell Huver")

