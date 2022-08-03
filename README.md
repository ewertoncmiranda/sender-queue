!!! EM CONSTRUÇÃO !!!

#Sender-queue

Microsserviço resṕonsável  por consumir stacks da AWS. Nesse projeto são consumidos as stacks:
- Amazon Simple Queue Service - SQS
- Amazon Simple Notification Service - SNS
- Amazon Simple Storage Service - S3
- Amazon Relation Database Service - RDS

Funcionalidades:

 *SNS*
- Cadastrar novo email em um tópico
- Enviar mensagem para o tópico

 *SQS*
- Ouve uma fila
- Enviar mensagem para a fila

 *S3*
- Faz um upload de uma arquivo para o bucket
- Busca pelo nome do arquivo cadastrado no bucket

 *RDS*
- Salva a mensagem enviada no tópico
- Busca a mensagem por id 


