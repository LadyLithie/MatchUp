INSERT INTO location (zipcode, city) VALUES
 ('75000','Paris'),
 ('69000','Lyon'),
 ('13000','Marseille'),
 ('59000','Lille'),
 ('35000','Rennes'),
 ('44000','Nantes'),
 ('33000','Bordeaux'),
 ('64000','Toulouse');

 INSERT INTO skills (name, type) VALUES
 ('JAVA', 'Langage'),
 ('SQL', 'Langage'),
 ('C', 'Langage'),
 ('C++', 'Langage'),
 ('Python', 'Langage'),
 ('HTML', 'Langage'),
 ('CSS', 'Langage'),
 ('Javascript', 'Langage'),
 ('Eclipse', 'Logiciel'),
 ('StarUML', 'Logiciel'),
 ('Git Bash', 'Logiciel'),
 ('Gestion des conflits', 'Social'),
 ('Symphony', 'Framework'),
 ('Gestion de projet', 'Management'),
 ('Négociation', 'Social'),
 ('Encadrer', 'management'),
 ('Comptabilité', 'Finance'),
 ('Marketing', 'Finance'),
 ('Code du travail', 'Droit'),
 ('Droit syndical', 'Droit'),
 ('Technique de documentation', 'Documentation'),
 ('Normes qualité', 'Contrôle'),
 ('Logiciels statistiques', 'Logiciel'),
 ('Sécurité incendie', 'Réglementation'),
 ('Secourisme', 'Sécurité'),
 ('Architecture fonctionnelle', 'Informatique'),
 ('Connaissance SOA', 'Informatique'),
 ('Diagnostic et résolution', 'Informatique'),
 ('Mise en production', 'Informatique'),
 ('Processus métiers', 'Informatique'),
 ('Gestion de bases de données', 'Informatique'),
 ('Plan de tests', 'Informatique'),
 ('Linux', 'Informatique'),
 ('Anglais technique', 'Language'),
 ('Espagnol', 'Language'),
 ('Anglais', 'Language'),
 ('Culture internet', 'Social'),
 ('Maîtrise d ouvrage', 'Gestion'),
 ('Elaborer un cahier des charges', 'Informatique'),
 ('Autonomie/Confiance   en soi', 'Comportementales'),
 ('Capacité d’adaptation', 'Comportementales'),
 ('Créativité/Sens de l innovation', 'Comportementales'),
 ('Diplomatie', 'Comportementales'),
 ('Rigueur/Fiabilité', 'Comportementales'),
 ('blabla', 'test');


INSERT INTO user (login, password, role, created_at) VALUES
('admin', 'admin','ADMIN', NOW()),
('Nat', 'pwd', 'candidate',NOW()),
('Jean', 'foot', 'candidate',NOW()),
('blablator', 'blator', 'CANDIDATE', NOW()),
('dieuxDuFoot', 'petrole','COMPANY',NOW()),
('makarof', 'fee','COMPANY',NOW()),
('Eisnstein', 'prof','COMPANY',NOW()),
('chapeauDePaille', 'luffy','COMPANY',NOW()),
('allstar', 'nexus','COMPANY',NOW()),
('carleric', 'non','COMPANY',NOW()),
('starforge', 'star','COMPANY',NOW()),
('userOne', 'null','COMPANY',NOW()),

INSERT INTO administrator (id, lastname, firstname, mail, phone) VALUES
(1, 'leboss', 'dujava', 'lebossdujava@orange.fr', '0845126398');

INSERT INTO candidate (id, lastname, firstname, mail, phone, presentation) VALUES
(2, 'DRAGNIR', 'Natsu', 'natsu.dragnir@orange.fr', '987654321', 'Bonjour je suis natsu DRAGNIR '),
(3, 'NEYMAR', 'Jean', 'jean.neymar@orange.fr', '1234567890', 'Bonjour je vaux 222 millions €'),
(4, null, null, 'blabla@super.tor', null, null),

INSERT INTO company (id, name, mail, phone, website, presentation) VALUES
(5, 'QUATAR', 'lesrichesduMoyenOrient@pretentieux.com', '102030405', 'lesrichesduMoyenOrient.com', 'Bonjour je possede une carte bleue non je voulais dire une carte dieu')
(6, 'FAIRYTAIL', 'fairytail@pauvre.com', '607080910', 'fairytail.com', 'Bonjour je suis une guilde'),
(7, 'SCIENCEINFUSE', 'lascienceinfuse@pretentieux.com', '9874561236', 'lascienceinfuse.com', 'Je sais tout'),
(8, 'ONEPIECE', 'lespiratesdunouveaumonde@pirate.com', '8569741252', 'lespiratesdunouveaumonde.com',  'Bonjour je suis le roi des pirates'),
(9, 'LOL', 'gamers@nolife.com', '4578129632', 'gamers.com',  'Bonjour je recherche des developpers/gamers'),
(10, 'TROLL', 'cestpasici@vienspas.com', '4525658579', '.com',  'Bonjour je ne recherche pas des trolls cest faux'),
(11, null,  'admin@starforge.inc', null, null, null),
(12, 'The Company', 'no email', null, null, null);

INSERT INTO job (title, created_at, presentation, contract_type, company_id) VALUES
('Développeur', NOW(), 'Recherche un développeur java', 'CDI', 5),
('Mage', NOW(), 'Recherche un mage de feu', 'INTERIM', 6),
('Footballeur', NOW(), 'Recherche un footballeur qui ne possede pas le bac et qui de preference ne sais pas écrire', 'ALTERNANCE', 5),
('Prof', NOW(), 'Recherche un prof qui a la science infuse', 'CDD', 7),
('Pirate', NOW(), 'Recherche un pirate sympa et riche', 'CONTRAT DE PROFESSIONALISATION', 8),
('Développeur/gamer', NOW(), 'Recherche un développeur qui joue à league of legend et qui rage jamais', 'ALTERNANCE', 9),
('Troll', NOW(), 'On vous prendra pas, pas la peine de postuler', 'CDI', 10),
('Web Dev', NOW(), 'Nous souhaitons renforcer notre équipe web pour un futur projet', 'ALTERNANCE', 5);