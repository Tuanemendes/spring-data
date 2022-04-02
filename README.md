


# Spring-data 

O framework spring-data  utiliza a linguagem java e facilita na criação de operaçãoes com o  CRUD para percistencia de dados, assim elevando o nível de
progamação transformando códigos fontes em poucas linhas, visto que o JPA "puro" gera  mais linha de código o spring-data veio facilitar a vida do 
programador com formas mais praticas e agéis. 

##  Inicio do projeto 
Com base no curso realizado pela plataforma <a href="https://www.alura.com.br">Alura</a>  com professor Kleber Nunes.
Esta sendo descrito os passos princiais para criação de um projeto spring-data  e com outras tecnoligias que estão sendo bastante utilizadas no mercado. 


### Requistos para o desenvolvimento do projeto
   Ter conhcecimento na liguagem Java,JPA,Percitencia em  Banco de dados , docker .
   Será criado um CRUD  (Criar, Buscar ou ler , atualizar e deletar).
   

**Observação:** Esse projeto visa descrever os  estudos e aprimoramentos no curso de formação Spring boot realizado pela plataforma Alura. 

### 🔧 Instalação

Projeto foi criado em uma máquina linux, mas pode ser feito em windows, mac. 
Para verificar se  a JDK está instalada  pode abrir o terminal e digitar:

```
java -version 
```
 Verificar a imagem docker:
 
```
docker images
```
Passo de configurações com o  dbeaver, deve se fazer as configurações para conexão:

```
*criar uma nova conexão no caso MariaDB , mas pode ser tilizado outros bancos de dados.
*Em edit conexções em serve host:127.0.0.1 porta : 3306 usarname:root passord:root  


```
**Observação:** Estes dados são muito importantes,pois
seram utilizados na aplications.yml no projeto spring-data  para o banco se concectar com o banco.   


## 🛠️ Ferramentas utilizadas para o desenvolvimento

 * [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) - JDK instalado na maquina a JDK.
 * [Eclipse](https://www.eclipse.org/downloads/) - IDE utilizada.
 * [Dbeaver](https://dbeaver.io/download/) - Visualisar o banco de dados.
 * [Docker](https://docs.docker.com/desktop/windows/install/) - Docker utilização da imagem do Banco MariaDB.
 * [MariaDB](https://hub.docker.com/_/mariadb) - Banco de dados utilizado.
 * [Spring Initializr](https://start.spring.io/)- Para iniciar o projeto com  as caracterias do spring. 


## 📌 Versão

 version="1.0"

## ✒️ Autores


* **Alura** - *Plataforma de cursos* - [Alura](https://github.com/alura-cursos)
* **Tuane**  - *Estudante* - [Tuane](https://github.com/Tuanemendes)

