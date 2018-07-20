# PlayingWithServlets


Com a IDE eclipse instalada, e com servidor  Tomcat 8, basta fazer:

File -> Import -> Web -> WAR file

Para rodar, basta clicar com botão direito sobre o projeto importado, run as, run on server.


Separação de funcionalidades por não conseguir integrar a tempo:

UploadImage (Classe UploadImage): Recebe a imagem do usuário e armazena como inputStream no StorageObjects.

Botão SendTest (Classe SendText): Recebe o conteúdo da planilha e faz o parser da string recebida, para os diversos arraylists de atributos presentes na estrutura singleton StorageObjects.

Botão Process Certification (Classe Certification): Recebe o texto que será colocado no certificado e é processado para verificar se há uso de tags, caso haja, substitui pela string vinda da planilha e previamente inserida. Também gera o pdf com a imagem e o texto já processado (apesar de o pdf gerado não estar bem organizado esteticamente).

O botão de enviar email não foi integrada com a classe que está pronta pra enviar emails (e que está funcionando, mas sem integração alguma por isso retirei a key do sendgrid).

Ou seja, o fluxo funcionando é: upload imagem, voltar para raiz, cola o conteúdo da planilha e clica em sendtest, voltar para raiz, digita o texto do certificado e clica em process certification para que os pdfs sejam gerados.
(PDFS gerados automaticamente no diretório user.dir do sistema, no meu caso, onde o eclipse foi instalado)

Bugs / Falhas Conhecidas:

Ao clicar em qualquer dos botões é redirecionado para tela vazia em vez de permanecer na mesma tela (No cenário ideal, com tudo pronto, esses botões extras adicionados nem existiriam).

Apenas o primeiro dos pdfs é gerado com sucesso, os próximos são gerados sem a imagem de background, apenas com o texto.