# PlayingWithServlets


Com a IDE eclipse instalada, e com servidor  Tomcat 8, basta fazer:

File -> Import -> Web -> WAR file

Para rodar, basta clicar com bot�o direito sobre o projeto importado, run as, run on server.


Separa��o de funcionalidades por n�o conseguir integrar a tempo:

UploadImage (Classe UploadImage): Recebe a imagem do usu�rio e armazena como inputStream no StorageObjects.

Bot�o SendTest (Classe SendText): Recebe o conte�do da planilha e faz o parser da string recebida, para os diversos arraylists de atributos presentes na estrutura singleton StorageObjects.

Bot�o Process Certification (Classe Certification): Recebe o texto que ser� colocado no certificado e � processado para verificar se h� uso de tags, caso haja, substitui pela string vinda da planilha e previamente inserida. Tamb�m gera o pdf com a imagem e o texto j� processado (apesar de o pdf gerado n�o estar bem organizado esteticamente).

O bot�o de enviar email n�o foi integrada com a classe que est� pronta pra enviar emails (e que est� funcionando, mas sem integra��o alguma por isso retirei a key do sendgrid).

Ou seja, o fluxo funcionando �: upload imagem, voltar para raiz, cola o conte�do da planilha e clica em sendtest, voltar para raiz, digita o texto do certificado e clica em process certification para que os pdfs sejam gerados.
(PDFS gerados automaticamente no diret�rio user.dir do sistema, no meu caso, onde o eclipse foi instalado)

Bugs / Falhas Conhecidas:

Ao clicar em qualquer dos bot�es � redirecionado para tela vazia em vez de permanecer na mesma tela (No cen�rio ideal, com tudo pronto, esses bot�es extras adicionados nem existiriam).

Apenas o primeiro dos pdfs � gerado com sucesso, os pr�ximos s�o gerados sem a imagem de background, apenas com o texto.