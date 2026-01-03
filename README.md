**Projet Systèmes Distribués - Semaine 2 : Multithreading & File de Messages**
📝 Description de la phase
L'objectif de cette deuxième semaine était de faire évoluer la communication réseau de base (Semaine 1) vers une architecture multithread. Cette étape est cruciale pour permettre à un nœud de recevoir des messages en continu sans bloquer son exécution, préparant ainsi le terrain pour la gestion de la causalité.

🛠️ Réalisations techniques
Dans cette phase, j'ai implémenté trois composants majeurs pour assurer la séparation entre la réception et le traitement des données :
*Gestion de la concurrence : Utilisation d'une LinkedBlockingQueue pour stocker les messages de manière "thread-safe", évitant ainsi les risques d'interférence entre les threads.
*ReceiverThread : Un thread dédié à l'écoute réseau. Il utilise les sockets TCP pour intercepter les messages et les insérer immédiatement dans la file d'attente.
*ProcessorThread : Un thread qui surveille la file d'attente. Dès qu'un message est disponible, il le récupère pour un traitement logique asynchrone.
*Modèle de données Message : Création d'une classe encapsulant le contenu et l'ID de l'expéditeur, utilisant des variables final pour garantir l'immuabilité des données pendant le transit entre threads.

🏗️ Architecture Interne d'un Nœud
Le schéma suivant illustre le flux de données mis en place cette semaine :
*Entrée : NetworkServer (Socket) -> ReceiverThread
*Tampon : BlockingQueue<Message>
*Sortie : ProcessorThread -> Affichage/Application

## Guide de Test
Pour vérifier le bon fonctionnement de la couche Multithreading dans VS Code :
*Lancement du Serveur : Exécutez MainServer.java. Le système lance automatiquement les threads de réception et de traitement.
*Simulation Client : Utilisez MainClient.java pour envoyer plusieurs messages rapidement.

### Validation :
Le serveur ne s'arrête pas après le premier message.
Les messages s'affichent dans la console via le ProcessorThread, prouvant que la file d'attente fonctionne correctement.

✅ Concepts Validés
[x] Multithreading simple (Threads de réception et de traitement).
[x] Synchronisation implicite via la file d'attente (Queue).
[x] Communication non-bloquante entre les threads.
